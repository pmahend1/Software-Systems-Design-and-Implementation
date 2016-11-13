
$(function () {
                $("#dialog").dialog({
                    modal: true,
                    autoOpen: false,
                    title: "Delete Account",
                    width: 300,
                    height: 150,
                    buttons:
                    { "No": function() {
                        $(this).dialog("close")
                    },"Yes": function(){
                        $(this).dialog("close")                                   
                        $.post("UserProfileManager",
                        {
                            "action": "deleteaccount",
                            "username": "${user.getUserName()}"
                        },
                        function(data,status){
                            window.location.href="index.jsp"; 
                        });
                     }
                 }
                 });
                
                $("#btnShow").click(function () {
                    $('#dialog').dialog('open');
                });
            });