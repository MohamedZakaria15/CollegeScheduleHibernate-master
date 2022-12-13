$(function() { 
  $('#sidebarCollapse').on('click', function() {
    $('#sidebar, #content,#sidebarCollapse').toggleClass('active');
  });
});

var textID=document.getElementById("Edittext");

function EditOnclick(){
  textID.innerHTML="Please Enter Valid Record ID That You Want To Edit"
  textID.style.color="#ff0000";
}

function validation(){
  var editID=document.getElementById("EditID").value;
  var editIDLen=editID.length;
  var editdisable= document.getElementsByClassName("disableElement");
  var pattern="123456";
  var paternLen=pattern.length;
  if (editID==pattern && editIDLen== paternLen){
    textID.innerHTML="Valid Record ID"
    textID.style.color="#00ff00";
    $(editdisable).removeAttr("disabled");
  }else{
    textID.innerHTML="Please Enter Valid Record ID that ID Not Exist"
    textID.style.color="#ff0000";
    $(editdisable).attr("disabled", "disabled");
  }
}
