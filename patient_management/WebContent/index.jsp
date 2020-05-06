<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Patients</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<form>
							<div class="form-group">
								<label for="patientName">Patient Name</label>
								<input id="name" type="text" placeholder="Type Patient Name" class="form-control form-control-sm" required/>
							</div>
							<div class="form-group">
								<label for="patientEmail">Patient ID</label>
								<input type="text" id="id" class="form-control form-control-sm" placeholder="Type Patient ID" required/>
							</div>
							<div class="form-group">
								<label for="emal">Email</label>
								<input type="email" id="email" placeholder="Type email Address" class="form-control form-control-sm" required/>
							</div>
							<div class="form-group">
								<label for="address">Address</label>
								<textarea id="address" rows="5" cols="5" style="resize: none" placeholder="Type Address" class="form-control"></textarea>
							</div>
							<div class="form-group">
								<label for="age">Age</label>
								<input type="number" class="form-control form-control-sm" placeholder="Type Age" id="age" required/>
							</div>
							<div class="form-group">
								<label for="telNumber">Tel Number</label>
								<input type="tel" placeholder="Type Telephone Number" id="telNumber" class="form-control form-control-sm" required/>
							</div>
							<div class="form-group">
								<button id="submitBtn" type="button" class="btn-sm btn btn-primary">Add</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#submitBtn').click(()=>{
			$.ajax({
				type:'POST',
				url:'http://localhost:8080/patient-management-system/PatientController',
				data:{
					name: $('#name').val(),
					address: $('#address').val(),
					age: $('#age').val(),
					email: $('#email').val(),
					telNumber: $('#telNumber').val()
				}
			}).then(response=>{
				console.log(response);
			}).catch(err=>{
				console.log(err);
			});
		});
	</script>
</body>
</html>