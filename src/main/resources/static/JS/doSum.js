function doSum() {
	var fn,
		ln,
		result;
	fn = parseInt(document.getElementById("n1").value, 10);
	ln = parseInt(document.getElementById("n2").value, 10);
	result = (fn + ln);

	if (isNaN(fn) || isNaN(ln)) {
		document.getElementById("result").innerHTML = "Please enter only numbers.";
	} else {
		$.getJSON("/page2/" + fn + "/" + ln,
			function(data) {
				document.getElementById("result").innerHTML = "Sum of the above two numbers is " + data;
			});
	}
}