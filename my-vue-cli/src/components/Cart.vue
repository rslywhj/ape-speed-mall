<template>
	<div>
		<v-header></v-header>
		<v-main></v-main>
		<v-footer></v-footer>
	</div>
</template>

<script>
	import Footer from "./Footer"
	import TestHeader from "./TestHeader"
	import Main from "./CartMain"
	export default {
		components: {
			"v-footer": Footer,
			"v-header": TestHeader,
			"v-main": Main,
		},
		name: 'Home',
		data() {
		},
	}
</script>

<style>
</style>
