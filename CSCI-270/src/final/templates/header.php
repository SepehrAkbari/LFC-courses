<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- META TAGS -->
        <meta charset="UTF-8">
        <meta name="description" content="Sepehr Akbari Digital Media Design Portfolio">
        <meta name="keywords" content="CSCI270, Lake Forest College, Sepehr Akbari, Portfolio, Art">
        <meta name="author" content="Sepehr Akbari">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- TITLE -->
        <title><?= $tab ?></title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Bootstrap Icons -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
        <!-- My CSS -->
        <link rel="stylesheet" href="/~akbaris79/csci270/final/styles/style.css">
        <link rel="stylesheet" href="/~akbaris79/csci270/final/styles/style_visuals.css">
        <link rel="stylesheet" href="/~akbaris79/csci270/final/styles/style_hf.css">
        <link rel="stylesheet" href="/~akbaris79/csci270/final/styles/contact.css">
        <!-- Favicon -->
        <link rel="icon" type="image/x-icon" href="/~akbaris79/csci270/final/visuals/SA_favicon.png">
    </head>
    <body>
        <!-- NAVBAR -->
        <nav class="navbar sticky-top navbar-expand-lg bg-body-tertiary fixed-top">
            <div class="container-fluid">
                <!-- LOGO -->
                <a class="navbar-brand" href="#">
                    <img src="/~akbaris79/csci270/final/visuals/SA_favicon.png" alt="logo" width="50">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                    <div class="offcanvas-header">
                        <img src="/~akbaris79/csci270/final/visuals/SA_favicon.png" alt="logo" width="50">
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <ul class="navbar-nav justify-content flex-grow-1 pe-3">
                            <!-- NAV ITEMS -->
                            <li class="nav-item">
                                <a class="nav-link <?= isset($Home) ? "active":"" ?>" <?= isset($Home) ? "aria-current='page' id='active-tab'":"" ?> href="/~akbaris79/csci270/final/">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link <?= isset($Gallery) ? "active":"" ?>" <?= isset($Gallery) ? "aria-current='page' id='active-tab'":"" ?> href="/~akbaris79/csci270/final/site/gallery.php">Gallery</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link <?= isset($About) ? "active":"" ?>" <?= isset($About) ? "aria-current='page' id='active-tab'":"" ?> href="/~akbaris79/csci270/final/site/about.php">About Me</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link <?= isset($Contact) ? "active":"" ?>" <?= isset($Contact) ? "aria-current='page' id='active-tab'":"" ?> href="/~akbaris79/csci270/final/site/contact.php">Contact Me</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Overview
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="/~akbaris79/csci270/final/visuals/sepehr_potfolio.pdf" download="sepehr_potfolio.pdf">Download Art Portfolio</a></li>
                                    <li><a class="dropdown-item" href="/~akbaris79/csci270/final/visuals/sepehr_resume.png" download>Download Resume</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <a id="top"></a>
