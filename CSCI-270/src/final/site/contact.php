<? 
$tab = 'Contact'; 
$Contact = true;
?>
<? require '../templates/header.php'; ?>
<div class="container-lg" style="min-height: 80vh; padding:50px 5px;">
    <div>
        <div class="row">
            <div class="col-12" style="text-align: justify;">
                <h1>
                    Say Hello!
                </h1>
                <br>
                <p>
                    I'd love to hear from you! Whether you have a project in mind, a question about my work, or just some friendly feedback, feel free to drop me a message. I'm always excited to connect with fellow creative minds and explore new possibilities. Don't hesitate to reach out - let's chat!
                </p>
            </div>
        </div>
    </div>
    <div class="container-fluid p-3"></div>
    <form method="post" action="../server/mail_engine.php">
        <!-- name -->
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Name</label>
            <input type="text" class="form-control" name="Name" id="exampleFormControlInput1">
        </div>
        <!-- email -->
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Email</label>
            <input type="text" class="form-control" name="Email" id="exampleFormControlInput1" placeholder="name@example.com">
        </div>
        <!-- phone -->
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Phone</label>
            <input type="text" class="form-control" name="Phone" id="exampleFormControlInput1" placeholder="Optional">
        </div>
        <!-- message -->
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">Message</label>
            <textarea class="form-control" name="Message" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>
        <!-- submit -->
        <button type="submit" class="btn btn-primary btn-lg">
                Send Message
        </button>
        <button type="reset" class="btn btn-outline-primary btn-lg">
                Clear
        </button>
    </form>
</div>
<? require '../templates/footer.php'; ?>
