# Copper Mountain Sokoban

WORK IN PROGRESS: This will be a very basic implementation of Sokoban. The one 
important difference is that the boxes and goals will be numbered.

The purpose of numbering the boxes and goals is to give Sokoban level designers 
another metric of how easy or difficult their levels are.

A level can start out with almost every box already on a goal and yet still be 
quite difficult because the player must move every one of those boxes to a 
different goal before being able to move the last box into a goal.

Contrast that to a level in which no box starts out on a goal, but the level can 
be quite easy if it's obvious to the player which box goes on which goal.

I'm thinking that boxes that start out on goals will be numbered with the prefix 
'G' (e.g., G1, G2, G3, etc.) and boxes that don't start out on goals will be 
numbered with the prefix 'F'.

I haven't yet decided which file format to support. Maybe both the XML-based SLC 
format and the "freer" SOK format. At least initially, I'm leaning to supporting 
only SLC. See [the document about file formats](FileFormats.md) for more 
details.

See my ASCII Sokoban project (GitHub repository is called sokoban-ascii) for a 
quick and dirty HTML, CSS and JavaScript implementation.
