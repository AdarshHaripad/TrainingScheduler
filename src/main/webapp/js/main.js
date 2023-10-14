document.getElementById("register-form").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  var name = document.getElementById("name").value;
  var email = document.getElementById("email").value;
  var pass = document.getElementById("pass").value;
  var rePass = document.getElementById("re_pass").value;
  var contact = document.getElementById("contact").value;

  if (name.trim() === "" || email.trim() === "" || pass.trim() === "" || rePass.trim() === "" || contact.trim() === "") {
    swal("Error", "Please fill out all the fields", "error");
    return false;
  }

  this.submit(); // Submit the form if validation passes
});
