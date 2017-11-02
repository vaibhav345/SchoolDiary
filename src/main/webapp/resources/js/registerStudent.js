jQuery(document).ready(function() {

     var submitForm = document.getElementById("submitButton");
     submitForm.onclick = function () {
        console.log("Submit Button Clicked");

        var name = document.getElementById("name").value;
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var email = document.getElementById("email").value;

        var json = {};
        json["id"] = 0;
        json["name"] = name;
        json["user_name"] = username;
        json["password"] = password;
        json["email"] = email;

        console.log(json);

        jQuery.ajax({
            url : jQuery("#regForm").attr("action"),
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json, text/plain");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data: JSON.stringify(json),
            success: function (data) {
                console.log("SUCCESS: ", data.msg);
                console.log(data.msg);
                //window.location.reload(true);
                if(data.msg == "hello") {
                    console.log("Call Sucsess");
                }
            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
            done: function (e) {
                console.log("DONE");
            }
        });
    }
});

