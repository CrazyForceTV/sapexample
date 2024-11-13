<template>
  <div class="container mt-5">
    <h2>{{ isEditing ? 'Team bearbeiten' : 'Neues Team' }}</h2>
    <form @submit.prevent="handleSubmit">
      <div class="row mb-3">
        <div class="col-md-3">
          <label for="name" class="form-label">Name</label>
          <input type="text" id="name" v-model="formData.name" class="form-control" required />
        </div>
        <div class="col-md-2">
          <label for="agej" class="form-label">Jahrgang Jung</label>
          <input type="number" id="agej" v-model="formData.agej" class="form-control" required />
        </div>
        <div class="col-md-2">
          <label for="agea" class="form-label">Jahrgang Alt</label>
          <input type="number" id="agea" v-model="formData.agea" class="form-control" required />
        </div>
        <div class="col-md-2">
          <label for="groupsizeNow" class="form-label">aktuelle Gruppengröße</label>
          <input
            type="number"
            id="groupsizeNow"
            v-model="formData.groupsizeNow"
            class="form-control"
          />
        </div>
        <div class="col-md-2">
          <label for="groupsizeMax" class="form-label">maximale Gruppengröße</label>
          <input
            type="number"
            id="groupsizeMax"
            v-model="formData.groupsizeMax"
            class="form-control"
          />
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-12">
          <div class="form-check">
            <input type="checkbox" id="open" v-model="formData.open" class="form-check-input" />
            <label for="open" class="form-check-label"
              >Weitere Leute einladen zum Probetraining</label
            >
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 text-center">
          <button type="submit" class="btn btn-primary">
            {{ isEditing ? 'Bearbeiten' : 'Anlegen' }}
          </button>
        </div>
      </div>
    </form>

    <h3 class="mt-5">Teams</h3>
    <table class="table">
      <thead>
        <tr>
          <th>Name</th>
          <th>Jahrgang Jung</th>
          <th>Jahrgang Alt</th>
          <th>Gruppengröße</th>
          <th>Weitere Aufnahme</th>
          <th>Aktion</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(team, index) in teams" :key="team.id">
          <td>{{ team.name }}</td>
          <td>{{ team.agej }}</td>
          <td>{{ team.agea }}</td>
          <td>{{ team.groupsizeNow }} / {{ team.groupsizeMax }}</td>
          <td>{{ team.open ? 'Ja' : 'Nein' }}</td>
          <td>
            <button @click="editTeam(index)" class="btn btn-warning btn-sm">Bearbeiten</button>
            <button @click="deleteTeam(team.id)" class="btn btn-danger btn-sm">Löschen</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref } from 'vue'
import axios from 'axios'

export default defineComponent({
  setup() {
    const formData = reactive({
      id: null,
      name: '',
      agej: null,
      agea: null,
      groupsizeNow: null,
      groupsizeMax: null,
      open: false,
    })

    const isEditing = ref(false)
    const currentIndex = ref<number | null>(null)

    const teams = ref<any[]>([])

    const loadTeams = async () => {
      try {
        const response = await axios.get(import.meta.env.VITE_SPRINGBOOT_TEAMS)

        teams.value = response.data.sort((a: { open: boolean }, b: { open: boolean }) => {
          if (a.open === b.open) {
            return 0
          }
          return a.open ? -1 : 1
        })
      } catch (error) {
        console.error('Fehler beim Laden der Teams:', error)
      }
    }

    loadTeams()

    const handleSubmit = async () => {
      try {
        console.log(formData.id)
        if (isEditing.value && formData.id) {
          await axios.put(`${import.meta.env.VITE_SPRINGBOOT_TEAMS}/${formData.id}`, {
            ...formData,
          })
        } else {
          await axios.post(import.meta.env.VITE_SPRINGBOOT_TEAMS, { ...formData })
        }
        await loadTeams()
        resetForm()
      } catch (error) {
        console.error('Fehler beim Speichern des Teams:', error)
      }
    }

    const resetForm = () => {
      formData.name = ''
      formData.agej = null
      formData.agea = null
      formData.groupsizeNow = null
      formData.groupsizeMax = null
      formData.open = false
    }

    const editTeam = (index: number) => {
      const team = teams.value[index]
      formData.id = team.id
      formData.name = team.name
      formData.agej = team.agej
      formData.agea = team.agea
      formData.groupsizeNow = team.groupsizeNow
      formData.groupsizeMax = team.groupsizeMax
      formData.open = team.open
      isEditing.value = true
      currentIndex.value = index
    }

    const deleteTeam = async (id: number) => {
      try {
        await axios.delete(`${import.meta.env.VITE_SPRINGBOOT_TEAMS}/${id}`)
        await loadTeams()
      } catch (error) {
        console.error('Fehler beim Löschen des Teams:', error)
      }
    }

    return {
      formData,
      isEditing,
      teams,
      handleSubmit,
      resetForm,
      editTeam,
      deleteTeam,
    }
  },
})
</script>
