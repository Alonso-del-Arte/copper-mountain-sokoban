# Game Rules

A Sokoban level consists of a floor with tiles, wall bricks, boxes, goals and a 
pusher (or pushers in the case of Multiban). The number of boxes must match the 
number of goals exactly. That is a requirement for a valid Sokoban level.

The object of the game is to get every box on a goal. At the beginning, some 
boxes may already be on goals, or they may even all be on goals (but in such a 
level, making any move disturbs the arrangement).

Most commonly, either all goals are empty or all goals except one have a box. In 
the latter case, it is generally necessary to move every box that is already on 
a goal to a different goal.

The player has a full view of the whole floor, but the pusher can only be moved 
one space at a time (up, down, left or right but not diagonally). The pusher can 
move over tiles but not over wall bricks nor over boxes.

The pusher can push a box, but only to a space with a tile that is not already 
occupied by another box nor by a wall brick. Boxes can't be placed on top of 
wall bricks.

A Sokoban implementation should clearly indicate when a box is on a goal. This 
may not always be practical, such as in cases in which the program allows the 
user to make "skins" for the game.

Once a level is solved after making one or more moves, the pusher should be 
locked. Though hopefully that's unnecessary in most cases, as the player sits 
back and admires their ingenuity.

Of course it also happens sometimes that the player makes a series of moves that 
puts the board in a state from which no solution is possible, such as, for 
example, pushing a box into a goalless corner from which it can't pushed out of.

For that reason, the program should provide both single-move undo (which may be 
applied repeatedly until the player returns the board to a state from which they 
think a solution is possible) as well as the ability to start over from the 
beginning.   

A valid Sokoban level is not required to have any solution, and it may be too 
difficult in some cases for a computer to determine for certain that a given 
level is in fact insoluble.

However, it is very bad manners to publish an insoluble level. Websites that 
allow users to publish Sokoban levels should require users to provide one 
solution as proof that the level is soluble, and as a condition for publication. 
And maybe also a hint that can be shown to stumped players.

When you complete a Sokoban level, you might have the opportunity to go to 
another level that is presumably slightly more difficult than the one you just 
completed.
