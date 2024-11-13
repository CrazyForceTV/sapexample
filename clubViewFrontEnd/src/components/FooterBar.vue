<template>
  <!-- CoreUI Footer immer fixiert unten -->
  <CFooter class="footer fixed-bottom py-3">
    <div class="container d-flex justify-content-between">
      <div>
        <CLink href="https://Warteliste.xyz">Warteliste.xyz</CLink>
        <span> &copy; {{ new Date().getFullYear() }} René Pannier</span>
      </div>
      <div>
        <span>Powered by</span>
        <CLink href="https://tekkcore.de">TekkCore</CLink>
      </div>
    </div>
  </CFooter>
</template>

<style scoped>
#app {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.footer.fixed-bottom {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  text-align: center;
  padding: 10px 0;
  z-index: 100;
}
</style>
