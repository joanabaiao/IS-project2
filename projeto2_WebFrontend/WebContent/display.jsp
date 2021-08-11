<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="style.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap"
			rel="stylesheet">
		<title>Project 2</title>
	</head>

	<body>
		<h1>Movies</h1>

		<div class="movie-list">

		<c:forEach var="movie" items="${movies}">

			<div class="movie">

				<img src="${movie.coverUrl}" alt="movie-cover" />

				<div class="movies-details">

					<h3>${movie.title}</h3>

					<h4>Year:</h4>
					<p>${movie.year}</p>
					<span class="br"></span>

					<h4>Rating:</h4>
					<p>${movie.rating}</p>
					<pre> (rated by ${movie.votes} people)</pre>
					<span class="br"></span>

					<h4>Rank position:</h4>
					<p>${movie.top250Rank}</p>
					<span class="br"></span>

					<h4>Runtime:</h4>
					<pre>${movie.runtimes} minutes</pre>
					<span class="br"></span>

					<h4>Countries:</h4>
					<c:forEach items="${movie.countries}" var="country" varStatus="loopStatus">
						${country}${!loopStatus.last?',':''}
					</c:forEach>
					<span class="br"></span>

					<h4>Genres:</h4>
					<c:forEach items="${movie.genres}" var="genre" varStatus="loopStatus">
						${genre}${!loopStatus.last?',':''}
					</c:forEach>
					<span class="br"></span>

					<h4>Cast:</h4>
					<c:forEach items="${movie.actors}" var="actor" varStatus="loopStatus">
						${actor.name}${!loopStatus.last?',':''}
					</c:forEach>
					<span class="br"></span>

					<h4>Directors:</h4>
					<c:forEach items="${movie.directors}" var="director" varStatus="loopStatus">
						${director.name}${!loopStatus.last?',':''}
					</c:forEach>
					<span class="br"></span>

					<h4>Description:</h4>
					<p>${movie.description}</p>
				</div>
			</div>
		</c:forEach>
	</div>

	</body>

	<footer>
		<br />
		<h4>Systems Integration - Project 2 - 2020/21</h4>
		<span class="br"></span>
		<p>André Bernardes 2017248159</p>
		<p>Joana Baião 2017260526</p>
	</footer>

</html>