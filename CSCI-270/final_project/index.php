<? 
$tab = 'Home';
$Home = true;
?> 
<? require 'templates/header.php'; ?>
        <!-- CAROUSEL -->
        <div id="carouselExample" class="carousel slide">
            <div class="carousel-inner">
                <div class="carousel-item carousel-image bg-img-1 active"></div>
                <div class="carousel-item carousel-image bg-img-2"></div>
                <div class="carousel-item carousel-image bg-img-3"></div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <div class="container-fluid p-3"></div>
        <div class="container-fluid p-3"></div>

        <!-- TEXT -->
        <div class="container">
            <div class="row">
                <div class="col-12" style="text-align: justify;">
                    <h1>
                        hello | درود
                    </h1>
                    <br>
                    <p>
                        Welcome to my art portfolio! I'm thrilled to have you step into my creative space and explore the collection of works I've poured my heart and soul into.  These pieces represent a journey - a visual chronicle of my artistic development, the ideas that ignite my passion, and the way I see and interpret the world around me. As you delve deeper, you'll encounter a diverse range of styles and mediums, each one a testament to my artistic exploration.  Whether it's the vectors representing objects, vibrant colors telling stories, or imaginary shapes that evoke emotions, each piece is a reflection of my unique perspective. I hope you'll find something that resonates with you, that sparks a conversation within, or simply leaves you with a sense of wonder.  So, take your time, browse freely, and let the art speak to you!                     
                    </p>
                </div>
            </div>
        </div>


        <div class="container-fluid p-3"></div>
        <div class="container-fluid p-3"></div>

        <!-- TEXT -->
        <div class="container">
            <div class="row">
                <div class="col-12" style="text-align: left">
                    <h3 class="text-primary-emphasis">
                        I Design, 
                    </h3>
                    <h3 class="text-danger-emphasis">
                        I Code,
                    </h3>
                    <h3 class="text-success-emphasis">
                        & Take the integral of Cos(x)
                    </h3>
                </div>
        </div>

        <br>

        <!-- ACCORDION -->
        <div class="accordion" id="accordionExample">
            <div class="accordion-item">
                <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                    Digital Media Design
                </button>
                </h2>
                <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <strong>I am doing a digital media design minor.</strong> My passion for crafting engaging digital experiences led me to pursue a minor in Digital Media Design. This minor has been instrumental in broadening my skillset, allowing me to translate ideas into captivating visuals for the digital realm. From user UI and graphical design to web development, my minor has equipped me with a strong foundation in the tools and techniques that shape the digital world.
                    <br><br>
                    Check out the Gallery, for some of my art work!
                    <br><br>
                    <button type="button" class="btn btn-outline-primary"><a class="btn" href="/~akbaris79/csci270/final/site/gallery.php">Visit Gallery</a></button>
                </div>
                </div>
            </div>

            <div class="accordion-item">
                <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    Computer Science
                </button>
                </h2>
                <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <strong>I major in Computer Science.</strong>My core studies lie in the world of Computer Science. This major has instilled in me a deep understanding of how computers work and the power of computational thinking. It's been an incredible journey, delving into areas like algorithms, programming languages, and data structures. This foundation allows me to not just design visually appealing experiences, but also understand the technical aspects that bring them to life.
                    <br><br>
                    To connect, follow me on GitHub! 
                    <br><br>
                    <button type="button" class="btn btn-outline-primary btn-sm"><a class="btn" href="https://github.com/SepehrAkbari" target="_blank">Connect</a></button>
                </div>
                </div>
            </div>
            <div class="accordion-item">
                <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    Mathematics
                </button>
                </h2>
                <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <strong>I am also minor in Math.</strong> My fascination with logical thinking led me to Mathematics. This minor has been a fantastic complement to my studies, sharpening my analytical skills and problem-solving abilities. The mathematical foundation I've gained allows me to approach challenges with a unique perspective and a knack for finding elegant solutions.
                    <br><br>
                    Feel free to reach out, my info is on my contact page!
                    <br><br>
                    <button type="button" class="btn btn-outline-primary btn-sm">
                        <a class="btn" href="mailto:isepehrakbari@gmail.com" target="_blank">Email</a>
                    </button>
                </div>
                </div>
            </div>
        </div>

        <div class="container-fluid p-3"></div>

        <!-- TEXT -->
        <div class="container">
            <div class="row">
                <div class="col-12" style="text-align: left">
                    <br>
                    <h3>Dive in</h3>
                </div>
            </div>
        </div>

        <br>

        <!-- CARDS -->
        <div class="row">
            <div class="col-sm-6 mb-3 mb-sm-0">
                <div class="card">
                <div class="card-body">
                    <h5 class="card-title">About Me</h5>
                    <p class="card-text">Get to know me better, so we can work together better.</p>
                    <a href="/~akbaris79/csci270/final/site/about.php" class="btn btn-primary" style="color:#fff">Learn More</a>
                </div>
                </div>
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Course Website</h5>
                    <p class="card-text">Feel free to visit my CSCI 270 class project as well.</p>
                    <a href="/~akbaris79/csci270/" class="btn btn-primary" style="color:#fff" target="_blank">Go</a>
                </div>
                </div>
            </div>
            <div class="py-2 d-none d-lg-block"></div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Contact Me</h5>
                    <p class="card-text">Get in touch with me. I'm ready to discuss project ideas, or even just a casual chat.</p>
                    <a href="/~akbaris79/csci270/final/site/contact.php" class="btn btn-primary" style="color:#fff">Get In Touch</a>
                </div>
                </div>
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Gallery</h5>
                    <p class="card-text">Browse some of my art works and learn about the mindset behind them as you go.</p>
                    <a href="/~akbaris79/csci270/final/site/gallery.php" class="btn btn-primary" style="color:#fff">Browse</a>
                </div>
                </div>
            </div>
        </div>

        <div class="container-fluid p-3"></div>
        <div class="container-fluid p-3"></div>
<? require 'templates/footer.php'; ?>
