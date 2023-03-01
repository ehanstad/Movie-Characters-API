-- Franchises --
INSERT INTO franchise (franchise_id, name, description) VALUES (1,'The Godfather', 'A tree run film franchise winning multiple awards');
INSERT INTO franchise (franchise_id, name, description) VALUES (2,'Star wars', 'A now owned Disney franchise containing to many movies to count');

-- Movies --
INSERT INTO movie (movie_id, title, genre, release_year, director, picture_url, trailer_link, franchise_id) VALUES (1,'Eternal sunshine of a spotless mind', 'Drama, Romance, Sci-Fi', 2004, 'Michel Gondry', 'https://m.media-amazon.com/images/M/MV5BMTY4NzcwODg3Nl5BMl5BanBnXkFtZTcwNTEwOTMyMw@@._V1_FMjpg_UX1000_.jpg', 'https://youtu.be/07-QBnEkgXU', null);
INSERT INTO movie (movie_id, title, genre, release_year, director, picture_url, trailer_link, franchise_id) VALUES (2,'What´s Eating Gilbert Grape', 'Drama', 1993, 'Lasse Hallström', 'https://m.media-amazon.com/images/M/MV5BMjU5NDllOTgtMjkzYy00ZWNmLThkMTItMzU0NzMxOTM2OWY2XkEyXkFqcGdeQXVyODc0OTEyNDU@._V1_.jpg', 'https://www.youtube.com/watch?v=nCsVjQaNV0E', null);
INSERT INTO movie (movie_id, title, genre, release_year, director, picture_url, trailer_link, franchise_id) VALUES (3,'The Godfather', 'Drama, Crime', 1972, 'Francis Ford Coppola', 'https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg', 'https://www.youtube.com/watch?v=UaVTIH8mujA', 1);

-- Characters --
INSERT INTO character (character_id, full_name, alias, gender, picture_URL) VALUES (1,,'Joel Barish', null, 'male', 'https://a1cf74336522e87f135f-2f21ace9a6cf0052456644b80fa06d4f.ssl.cf2.rackcdn.com/images/characters/large/800/Joel-Barish.Eternal-Sunshine-of-the-Spotless-Mind.webp');
INSERT INTO character (character_id, full_name, alias, gender, picture_URL) VALUES (2,'Clementine Kruczynski', null, 'female', 'https://static.wikia.nocookie.net/filmguide/images/d/d3/Clementine_Kruczynski.jpg/revision/latest?cb=20220830183357');
INSERT INTO character (character_id, full_name, alias, gender, picture_URL) VALUES (3,'Gilbert Grape', null, 'male', 'https://ia.media-imdb.com/images/M/MV5BMTUzNzU4NzY0NV5BMl5BanBnXkFtZTcwMzQzNTY3Mw@@._CR343,2,1287,1287_UX402_UY402.jpg');
INSERT INTO character (character_id, full_name, alias, gender, picture_URL) VALUES (4,'Arnie Grape', null, 'male', 'https://m.media-amazon.com/images/M/MV5BMjIxMzY0NTM1OV5BMl5BanBnXkFtZTcwNTQzNTY3Mw@@._V1_.jpg');
INSERT INTO character (character_id, full_name, alias, gender, picture_URL) VALUES (5,'Don Vito Corleone', null, 'male', 'https://upload.wikimedia.org/wikipedia/en/2/21/Godfather15_flip.jpg');
INSERT INTO character (character_id, full_name, alias, gender, picture_URL) VALUES (6,'Michael Corleone', null, 'male', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.esquire.com%2Fentertainment%2Fmovies%2Fa38121732%2Fmichael-corleone-the-godfather-legacy%2F&psig=AOvVaw1g7ErjgWEJHNgTqLY2UWis&ust=1677323007270000&source=images&cd=vfe&ved=0CA0QjRxqFwoTCLjDvKOBrv0CFQAAAAAdAAAAABAD');

-- Movie Character connection --
INSERT INTO movie_characters (movies_movie_id, characters_character_id) VALUES (1, 1);
INSERT INTO movie_characters (movies_movie_id, characters_character_id) VALUES (1, 2);
INSERT INTO movie_characters (movies_movie_id, characters_character_id) VALUES (2, 3);
INSERT INTO movie_characters (movies_movie_id, characters_character_id) VALUES (2, 4);
INSERT INTO movie_characters (movies_movie_id, characters_character_id) VALUES (3, 5);
INSERT INTO movie_characters (movies_movie_id, characters_character_id) VALUES (3, 6);
--INSERT INTO movie_characters (movies_movie_id, characters_character_id) VALUES (2, 1);