<script setup>
import { ref } from 'vue'
const visible = ref(true)
</script>
<template>
  <CNavbar placement="sticky-top" expand="lg" color-scheme="dark" class="bg-dark">
    <CContainer fluid>
      <CNavbarBrand href="#">Warteliste.xyz</CNavbarBrand>
      <CNavbarToggler @click="visible = !visible" />
      <CCollapse class="navbar-collapse" :visible="visible">
        <CNavbarNav class="me-auto mb-2 mb-lg-0">
          <CNavItem>
            <CNavLink href="/"> Home </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink href="/teams" active>Teams</CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink href="/training">Trainingzeit</CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink href="/trainer">Trainer</CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink href="/club">Vereinsdaten</CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink href="/impressum">Impressum</CNavLink>
          </CNavItem>
        </CNavbarNav>
      </CCollapse>
    </CContainer>
  </CNavbar>
</template>
