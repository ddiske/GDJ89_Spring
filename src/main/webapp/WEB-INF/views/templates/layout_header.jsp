<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="container-fluid ">
	<div class="row">
		<nav
			class="navbar navbar-expand-lg bg-body-tertiary bg-dark border-bottom border-body"
			data-bs-theme="dark">
			<div class="container-fluid">
				<div class="row col-md-8 offset-md-2">
					<a class="navbar-brand" href="#">Navbar</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
						aria-controls="navbarNavDropdown" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNavDropdown">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="/">Home</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/products/list">Products</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
							</li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> Dropdown
									link </a>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="#">Action</a></li>
									<li><a class="dropdown-item" href="#">Another action</a></li>
									<li><a class="dropdown-item" href="#">Something else
											here</a></li>
								</ul>
							</li>
							<ul class="navbar-nav">
							<li class="nav-item">
								<a class="nav-link active"
								aria-current="page" href="/users/login">로그인</a>
							</li>
							<li class="nav-item">
								<a class="nav-link active"
								aria-current="page" href="/users/join">회원가입</a>
							</li>
							</ul>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</div>
</header>