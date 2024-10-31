<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Homepage for csci270 course at LFC">
        <meta name="keywords" content="CSCI 270, LFC, DMD Program">
        <meta name="author" content="Sepehr Akbari">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="https://necolas.github.io/normalize.css/8.0.1/normalize.css">
        <link rel="stylesheet" href="/~akbaris79/csci270/static/styles.css">

        <title><?= $page_title ?></title>
        <link rel="icon" type="image/x-icon" href="/~akbaris79/csci270/images/SA_favicon.png">

        <? if ( is_array($extra_stylesheets) ) { ?>
            <? foreach ($extra_stylesheets as $stylesheet) { ?>
            <link rel="stylesheet" type="text/css" href="<?=$stylesheet?>" >
            <? } ?>
        <? } ?>
    </head>
    <body>
        <div id="page_wrapper">
            <a id="top"></a>
            <div id="header">
                <div class="hero-bg">
                    <div class="hero">
                        <div class="col75">
                            <h1>CSCI 270 DMD Project:<br>Web Development</h1>
                        </div>
                        <div class="col25">
                            <img src="/~akbaris79/csci270/images/SA_favicon.png" class="logo" alt="logo" width="70">
                        </div>
                        <div class="clear_float"></div>
                    </div>
                </div>
                <hr>
                <div class="col100">
                    <ul id="nav">
                        <li class=<?= isset($Home) ? "active_nav":"na" ?>><a href="/~akbaris79/csci270/index.php">Home</a></li>
                        <li class=<?= isset($Lists) ? "active_nav":"na" ?>><a href="/~akbaris79/csci270/site/lists_page/lists.php">Lists</a></li>
                        <li class=<?= isset($Blocks) ? "active_nav":"na" ?>><a href="/~akbaris79/csci270/site/blocks_page/blocks.php">Blocks</a></li>
                        <li class=<?= isset($Images) ? "active_nav":"na" ?>><a href="/~akbaris79/csci270/site/images_page/images.php">Images</a></li>
                        <li class=<?= isset($Positioning) ? "active_nav":"na" ?>><a href="/~akbaris79/csci270/site/positioning_page/positioning.php">Positioning</a></li>
                        <li><a href="/~akbaris79/csci270/site/responsive_page/responsive_example.html" target="_blank">RWD</a></li>   
                        <li class=<?= isset($Contact) ? "active_nav":"na" ?>><a href="/~akbaris79/csci270/site/contact_page/contact_form.php">Contact</a></li>
                        <li><a href="/~akbaris79/csci270/final/" target="_blank">Final Project</a></li>
                    </ul>
                </div>
                <div class="clear_float"></div>
                <hr>
            </div>
            <div id="main">
