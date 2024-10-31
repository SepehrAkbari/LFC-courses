<?php

//////////////////////////////////////////////////////////////////////////
// Edit this strings to match your info
//////////////////////////////////////////////////////////////////////////

$emailFrom = "akbaris79@lakeforest.edu";
$emailTo = "akbaris79@lakeforest.edu";
$subject = "New Message | ART PORTFOLIO";

//////////////////////////////////////////////////////////////////////////
// DONT Edit below here unless you know what you are doing.
//////////////////////////////////////////////////////////////////////////

$name = trim(stripslashes($_POST['Name']));
$email = trim(stripslashes($_POST['Email']));
$phone = trim(stripslashes($_POST['Phone']));
$message = trim(stripslashes($_POST['Message']));

// validation - we don't wan't to accept bogus input from the user
If ( $name == '' || email_addr_is_bad($email) || $message == '' ) {
  header ("Location: error.php");
  exit;
}

// prepare email body text
// This email is just for you, so it doesn't need to be fancy
$body = "";
$body .= "Name: $name \n";
$body .= "Email: $email \n";
$body .= "Phone: $phone \n";
$body .= "Message: $message \n";

// send email
$success = mail($emailTo, $subject, $body, "From: <$emailFrom>");

// redirect to success page
if ($success) {
  header ("Location: success.php");
}
else {
  header ("Location: error.php");
}
exit;

function email_addr_is_bad($addr) {
    if (preg_match('/^[^\W][a-zA-Z0-9_]+(\.[a-zA-Z0-9_]+)*\@[a-zA-Z0-9_]+(\.[a-zA-Z0-9_]+)*\.[a-zA-Z]{2,4}$/',$addr)) {
      return false;
    }
    return true;
}

?>
