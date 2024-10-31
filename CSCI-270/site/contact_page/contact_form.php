<? 
$page_title = 'Contact | CSCI 270'; 

$li_1 = 'na';
$li_2 = 'na';
$li_3 = 'na';
$li_4 = 'na';
$li_5 = 'active_nav';

$extra_stylesheets[] = 'contact_style.css';  
?>
<? require '../../templates/site_header.php'; ?>
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

    <button type="submit"> Contact Me </button>
    <br style="clear:right;"> <!-- clears float on the button -->

  </form>
</div>
<? require '../../templates/site_footer.php'; ?>
