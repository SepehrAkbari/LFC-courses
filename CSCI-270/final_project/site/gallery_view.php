<? 
$tab = 'Gallery';
?> 
<? require '../templates/header.php'; ?>
<div class="container-fluid p-3"></div>
<div class="container">
    <div class="row">
        <?php
            $image_id = isset($_GET['image']) ? $_GET['image'] : null;

            if ($image_id == 1) {
                echo "<h3>THE BLOODY STORY CITY</h3>";
                echo "<p>A play on the musical “story city”, using the symbolism within the elephant as a real person, his personality altered, bloody shirt and gun to head.</p>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<img src='/~akbaris79/csci270/final/visuals/art/Frame1.jpeg' class='img-fluid' alt='Your browser does not support this image format'>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<div class='col-12'>
                            <H5>Like This?</H5>
                            <button type='button' class='btn btn-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/visuals/art/Frame1.jpeg' style='color:#fff' download>Download</a></button>
                            <button type='button' class='btn btn-outline-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/site/gallery.php'>Back</a></button>
                        </div>";
            } else if ($image_id == 2) {
                echo "<h3>TANGLED IN RED</h3>";
                echo "<p>A gathering of elements signifying the root of resistance in the context of iran, through boldly socialism. a mix of persian and socialist symbols tangled in red.</p>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<img src='/~akbaris79/csci270/final/visuals/art/Frame2.jpeg' class='img-fluid' alt='Your browser does not support this image format'>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<div class='col-12'>
                            <H5>Like This?</H5>
                            <button type='button' class='btn btn-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/visuals/art/Frame2.jpeg' style='color:#fff' download>Download</a></button>
                            <button type='button' class='btn btn-outline-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/site/gallery.php'>Back</a></button>
                        </div>";
            } else if ($image_id == 3) {
                echo "<h3>BEHAVIORS 01</h3>";
                echo "<p>The behavior of a ultra simple element, used in a way, and of certain color to create symmetry and depth in the shape(s). </p>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<img src='/~akbaris79/csci270/final/visuals/art/Frame3.jpeg' class='img-fluid' alt='Your browser does not support this image format'>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<div class='col-12'>
                            <H5>Like This?</H5>
                            <button type='button' class='btn btn-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/visuals/art/Frame3.jpeg' style='color:#fff' download>Download</a></button>
                            <button type='button' class='btn btn-outline-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/site/gallery.php'>Back</a></button>
                        </div>";
            } else if ($image_id == 4) {
                echo "<h3>BEHAVIORS 10</h3>";
                echo "<p>The behavior of a ultra simple element, used in a way, and of certain color to create asymmetry and the illusion of a known shape, while not being one.</p>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<img src='/~akbaris79/csci270/final/visuals/art/Frame4.jpeg' class='img-fluid' alt='Your browser does not support this image format'>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<div class='col-12'>
                            <H5>Like This?</H5>
                            <button type='button' class='btn btn-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/visuals/art/Frame4.jpeg' style='color:#fff' download>Download</a></button>
                            <button type='button' class='btn btn-outline-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/site/gallery.php'>Back</a></button>
                        </div>";
            } else if ($image_id == 5) {
                echo "<h3>ASHED PHOENIX</h3>";
                echo "<p>Illustration of the portrait of nouraldin kianouri. the caption reads: “we gave a minute of silence for justice, they took our freedom”.</p>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<img src='/~akbaris79/csci270/final/visuals/art/Frame5.jpeg' class='img-fluid' alt='Your browser does not support this image format'>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<div class='col-12'>
                            <H5>Like This?</H5>
                            <button type='button' class='btn btn-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/visuals/art/Frame5.jpeg' style='color:#fff' download>Download</a></button>
                            <button type='button' class='btn btn-outline-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/site/gallery.php'>Back</a></button>
                        </div>";
            } else if ($image_id == 6) {
                echo "<h3>TICK TICK TI-</h3>";
                echo "<p>Image of a clock, illustrated in high detail.</p>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<img src='/~akbaris79/csci270/final/visuals/art/Frame6.jpeg' class='img-fluid' alt='Your browser does not support this image format'>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<div class='col-12'>
                            <H5>Like This?</H5>
                            <button type='button' class='btn btn-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/visuals/art/Frame6.jpeg' style='color:#fff' download>Download</a></button>
                            <button type='button' class='btn btn-outline-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/site/gallery.php'>Back</a></button>
                        </div>";
            } else if ($image_id == 7) {
                echo "<h3>I</h3>";
                echo "<p>My name “sepehr akbari”, written in persian/farsi. the letters have been rearrenged to give the piece a more delight presentation. the name is still completely readable.</p>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<img src='/~akbaris79/csci270/final/visuals/art/Frame7.jpeg' class='img-fluid' alt='Your browser does not support this image format'>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<div class='col-12'>
                            <H5>Like This?</H5>
                            <button type='button' class='btn btn-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/visuals/art/Frame7.jpeg' style='color:#fff' download>Download</a></button>
                            <button type='button' class='btn btn-outline-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/site/gallery.php'>Back</a></button>
                        </div>";
            } else if ($image_id == 8) {
                echo "<h3>SHIAS ARE FRIENDS. OTHERS DEAD.</h3>";
                echo "<p>A design inspired by the works of john heart-field, representing the cover of a jewish magazine, showcasing the relation of the ayatollah and ismail haniyeh; the text reads: “victory comes from executions”.</p>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<img src='/~akbaris79/csci270/final/visuals/art/Frame8.jpeg' class='img-fluid' alt='Your browser does not support this image format'>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<div class='col-12'>
                            <H5>Like This?</H5>
                            <button type='button' class='btn btn-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/visuals/art/Frame8.jpeg' style='color:#fff' download>Download</a></button>
                            <button type='button' class='btn btn-outline-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/site/gallery.php'>Back</a></button>
                        </div>";
            } else if ($image_id == 9) {
                echo "<h3>SHADES OF '0</h3>";
                echo "<p>Through altering only size of circles, the meaning of “increase” is translated.</p>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<img src='/~akbaris79/csci270/final/visuals/art/Frame9.jpeg' class='img-fluid' alt='Your browser does not support this image format'>";
                echo "<div class='container-fluid p-3'></div>";
                echo "<div class='col-12'>
                            <H5>Like This?</H5>
                            <button type='button' class='btn btn-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/visuals/art/Frame9.jpeg' style='color:#fff' download>Download</a></button>
                            <button type='button' class='btn btn-outline-primary btn-lg'><a class='btn' href='/~akbaris79/csci270/final/site/gallery.php'>Back</a></button>
                        </div>";
            } else {
                echo "ERROR: Image not found.";
            }
        ?>
    </div>
</div>

<div class="container-fluid p-3"></div>
<? require '../templates/footer.php'; ?>
