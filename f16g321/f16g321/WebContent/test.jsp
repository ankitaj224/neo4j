<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>f16g321 Test</title>
</head>
<body>
	<h1 align="center">IDS517 f16g321</h1>
	<hr />
	<br />
	<div align="center">
		<table>

			<tr>
				<td><a href="student.jsp">Back</a>&nbsp;&nbsp;&nbsp;</td>
				<td><a href="index.jsp">Home</a>&nbsp;&nbsp;&nbsp;</td>
				<td><a href="help.jsp">Get Help</a>&nbsp;&nbsp;&nbsp;</td>
				<td><a href="logout.jsp">Logout</a></td>
			</tr>
		</table>
	</div>
	<div align="left">
		
			<table>
				<tr>
					<th>Statistics Anova Quiz</th>
				</tr>
			</table>
		
	</div>
<form action="feedback.jsp">
	<p class="question">1. We can check the assumptions for ANOVA</p>

	<ul class="answers">
		<input type="radio" name="q1" value="a" id="q1a">
		<label for="q1a"> Very specifically </label>
		<br />
		<input type="radio" name="q1" value="b" id="q1b">
		<label for="q1b">Approximately by examining population
			statistics </label>
		<br />
		<input type="radio" name="q1" value="c" id="q1c">
		<label for="q1c"> Approximately by examining sample statistics
			and charts of the sample data </label>
		<br />
	</ul>


	<p class="question">2. If the global significance test for ANOVA
		fails to reject Ho, then you may</p>

	<ul class="answers">
		<input type="radio" name="q2" value="a" id="q2a">
		<label for="q2a"> Proceed with multiple comparisons but not
			with contrasts </label>
		<br />
		<input type="radio" name="q2" value="b" id="q2b">
		<label for="q2b"> Proceed with contrasts but not with multiple
			comparisons </label>
		<br />
	</ul>

	<p class="question">3. To assess the ANOVA assumptions of
		[Normality;standard deviation] we use (read carefully)</p>

	<ul class="answers">
		<input type="radio" name="q3" value="a" id="q3a">
		<label for="q3a">Ratio of largest to smallest population
			standard deviation is less than 2; no major departures on the
			quantile plots </label>
		<br />
		<input type="radio" name="q3" value="b" id="q3b">
		<label for="q3b"> No major departures on the quantile
			plots;Ratio of largest to smallest population standard deviation is
			less than 2</label>
		<br />
		<input type="radio" name="q3" value="c" id="q3c">
		<label for="q3c"> No major departures on the quantile
			plots;Ratio of largest to smallest sample standard deviation is less
			than 2</label>
		<br />
	</ul>

	<p class="question">4. The main assumptions of ANOVA are</p>

	<ul class="answers">
		<input type="radio" name="q4" value="a" id="q4a">
		<label for="q4a"> Normal populations and linear relationships
		</label>
		<br />
		<input type="radio" name="q4" value="b" id="q4b">
		<label for="q4b"> Normal populations and consistent standard
			deviations </label>
		<br />
	</ul>

	<p class="question">5. If the probabilities of making a mistake in
		comparing different drugs are independent and alpha=1% then the
		probability of making a mistake when making both comparisons (the
		intersection) is</p>
	<ul class="answers">
		<input type="text" name="q5" id="q5c" />
		<br />
	</ul>
	<input type="submit" value="Submit" />
	<input type="button" value="Cancel" />
	</form>
</body>
</html>