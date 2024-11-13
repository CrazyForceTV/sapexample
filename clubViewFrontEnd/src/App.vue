<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import NavBar from './components/NavBar.vue'
import FooterBar from './components/FooterBar.vue'
import { createI18n } from 'vue-i18n';
</script>

<template>
  <NavBar />
  <RouterView />
  <FooterBar />
</template>
