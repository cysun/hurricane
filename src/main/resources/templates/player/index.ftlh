<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Hurricanes Soccer Academy</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.2/dist/sketchy/bootstrap.min.css"
            integrity="sha256-f7hJZyBzAwE4o9BfboUSmbbh6H763Cx/0gPiuvxYSJc="
            crossorigin="anonymous"
    />
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
    />
</head>
<body class="container">
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <i class="bi bi-globe"></i>
            Hurricanes Soccer Academy</a
        >
        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/players">Players</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/teams">Teams</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<h2 class="mt-3">Players</h2>
<div class="text-end">
    <a href="players/add" class="btn btn-primary">New Player</a>
</div>
<#list players>
<table class="table table-striped table-hover align-middle">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Age</th>
        <th scope="col">Team</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <#items as player>
        <tr>
            <td>${player.id}</td>
            <td>${player.name}</td>
            <td>${player.age}</td>
            <td><#if player.team??>${player.team.id}</#if></td>
            <td><a href="players/edit/${player.id}" class="btn btn-primary">Edit</a></td>
        </tr>
    </#items>
    </tbody>
    </#list>
</table>
<div class="bg-body-tertiary mt-3 p-3 text-center">
    Hurricanes Soccer Academy - Serving Claremont and Surrounding Areas
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"
></script>
</body>
</html>
