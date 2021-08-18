<template>
	<div>
		<footer class="bs-docs-footer">
			<div class="container">
				<ul class="bs-docs-footer-links">
					<li><a href="#">张玉佳</a></li>
					<li><a href="#">吴大中</a></li>
					<li><a href="#">李厚江</a></li>
					<li><a href="#">潘帅</a></li>
				</ul>

				<p>Copied and Modify with all the love in the world by <a href="#">@Wu</a>. Maintained by the <a
						href="#">Ape-Speed team
					</a> with the help of <a href="https://v3.bootcss.com/css/#less">our contributors
					</a>
				</p>

				<h1 style="color: rgb(174,99,41 )">风雨五组</h1>

			</div>
		</footer>
	</div>

</template>

<script>
	import Header from "@/components/Header"
	export default {
		name: 'footer',
		data(){
			return{

			}
		},
		components:Header,
	}
</script>

<style>
	.bs-docs-footer {
		padding-top: 20px;
		padding-bottom: 10px;
		margin-top: 100px;
		color: #99979c;
		text-align: center;
		background-color: #2a2730;
		box-sizing: border-box;
	}

	.bs-docs-footer-links li {
		display: inline-block;
	}

	.bs-docs-footer-links li+li {
		margin-left: 15px;
	}

	.bs-docs-footer a {
		color: #fff;
	}

	a {
		color: #337ab7;
		text-decoration: none;
	}

	p {
		margin: 0 0 10px;
	}

	.container {
		padding-right: 15px;
		padding-left: 15px;
		margin-right: auto;
		margin-left: auto;
	}

	.bs-docs-footer-links {
		padding-left: 0;
		margin-bottom: 20px;
	}
</style>
