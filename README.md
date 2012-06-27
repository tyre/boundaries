## boundaries
==========

Simple Noir service that returns a boundary around a given latitude/longitude pair.

Currently running on Heroku at http://deep-stone-8106.herokuapp.com

### Use

Send a URI encoded request to '/boundary' with latitude, longitude, and distance parameters. You will receive a JSON response with the maximum and minimum latitude/longitude coordinates of the bound box.

### Example

GET request to http://deep-stone-8106.herokuapp.com/boundary?latitude=39&longitude=39&distance=40

returns:

{"maximum":{"latitude":39.57757842251091,"longitude":39.7432045602194},"minimum":{"latitude":38.42242157748909,"longitude":38.2567954397806}}

where maximum is the upper right hand corner and minimum is the lower left hand corner of a box around [39, 39] with sides of 80mi.

This is a box. It gives you the stars.

 ________*
|        |
|        |
|        |
|*_______|

