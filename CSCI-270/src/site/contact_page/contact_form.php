<? 
$page_title = 'Contact | CSCI 270'; 

$Contact = true;

$extra_stylesheets[] = 'contact_style.css';  
?>
<? require '../../templates/site_header.php'; ?>
<div class="c50p_l">
  <div id="contact_form_wrapper">
    <form method="post" action="contact_engine.php">

      <!--
        Do NOT change the names of the form elemnts.
        That will break the PHP script this form Submits to.

        Notice how each label is "for" a specific input field.
      -->

      <label for="Name">Name:</label>
      <input type="text" name="Name" id="Name">

      <br><br>

      <label for="Email">Email:</label>
      <input type="text" name="Email" id="Email">

      <br><br>

      <label for="Phone">Phone:</label>
      <input type="text" name="Phone" id="Phone" placeholder="Optional">

      <br><br>

      <label for="Message">Message:</label><br >
      <textarea name="Message" id="Message" rows="10"></textarea>

      <br><br>

      <button type="submit"> Send Message </button>
      <div class="clear_float"></div>
    </form>
  </div>
</div>
<div class="c50p_r">
  <h3>Contact Me</h3>
  <p>I'm always happy to chat and collaborate. You can reach me through this contact form, and I will get back to you as soon as possible.</p>
  <p>Connect further by following me on <a class="drctLnk" href="https://github.com/SepehrAkbari" target="_blank">Github</a>.</p>
</div>
<div class="clear_float"></div>
<? require '../../templates/site_footer.php'; ?>