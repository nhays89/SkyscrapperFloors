# [SkyScrapper Floors](https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&category=416&page=show_problem&problem=3545)

European Reginals ICPC programming problem. 1998. Time: 3 seconds.

<p>

<img src="https://pbs.twimg.com/profile_images/587310348102844417/h5kO7WIy.jpg">

</p>

## Problem
What a great idea it is to build skyscrapers! Using not too large area of land, which is very expensive
in many cities today, the skyscrapers offer an extremely large utility area for flats or offices. The only
disadvantage is that it takes too long to get to the upper floors. Of course these skyscrapers have to
be equiped not only with a stairway but also with several elevators. But even using ordinary elevators
is very slow. Just imagine you want to get from the very top floor to the base floor and many other
people on other floors want the same. As a result the elevator stops on almost every floor and since
its capacity is limited and the elevator is already full from the upper floors, most stops are useless and
just cause a delay. If there are more elevators in the skyscrapers, this problem is a little bit eliminated
but still not completely. Most people just press all the buttons of all the elevators and then take the
first one so that all elevators will stop on the floor anyway.
However, the solution exists as we shall see. The Antique Comedians of Midilesia headquarters
reside in a skyscraper with a very special elevator system. The elevators do not stop on every floor
but only on every X-th floor. Moreover each elevator can go just to a certain floor Y (called starting
floor) and cannot go any lower. There is one high-capacity elevator which can stop on every elevator’s
starting floor.
The ACM has a big problem. The headquarters should be moved to another office this week,
possibly on a different floor. Unfortunately, the high-capacity elevator is out of order right now so it is
not always possible to go to the base floor. One piece of furniture cannot be moved using the stairway
because it is too large to pass through the stairway door. You are to write a program that decides
whether it is possible to move a piece of furniture from the original office to the other.


## Input
The input consists of <em>N</em> cases. The first line contains only one positive integer <em>N</em>. Then follow the
cases. Each case starts with a line containing four integers <em>F</em>,<em>E</em>, <em>A</em>, <em>B</em>, where <em>F</em>, 1 ≤ <em>F</em> < 50000000
determines the number of floors in the skyscraper (this means that there are floors 0 to <em>F</em> − 1), <em>E</em>,
0 < <em>E</em> < 100 is the number of elevators and <em>A</em>, <em>B</em>, 0 ≤ <em>A</em>, <em>B</em> < <em>F</em> are numbers of the two floors between
which the piece of furniture should be moved. Then follow <em>E</em> lines. Each of them contains description
of one elevator. There are exactly two integers <em>X</em> and <em>Y</em> , <em>X</em> > 0, <em>Y</em> ≥ 0 at each line. <em>Y</em> determines,
that the elevator starts on the <em>Y</em> -th floor and <em>X</em> determines, that it stops on every <em>X</em>-th floor, e.g. for
<em>X</em> = 3, <em>Y</em> = 7 the elevator stops on floors 7, 10, 13, 16, etc.).

## Output
For each case, print exactly one line. If floor <em>B</em> is reachable from floor <em>A</em> not using the stairway, print
the sentence **‘It is possible to move the furniture.’** otherwise print **‘The furniture cannot
be moved.’**

## Solution
For this problem, its tempting to build a recursive algorithm that checks all possible stops from the starting floor, Y, to 
the ending floor, X, but the input size is simply to large. Instead, lets leverage the idea that if an elevator, e<sub><em>i</em></sub>, stops on a floor
that overlaps with another elevator, e<sub><em>j</em></sub>, then a piece of furniture can move to and from any stop of either elevator. The merge between the two elevators
creates an elevator, e<sub><em>m</em></sub>, that represents all possible stops of each elevator (e<sub><em>i</em></sub> +  e<sub><em>j</em></sub>). Therefore, lets extend this idea to each remaining elevator, e<sub><em>k</em></sub>, in the input, gradually
increasing the number of all possible stops as we merge elevators with e<sub><em>m</em></sub>. There may be the case, however, in which an elevator, e<sub><em>i</em></sub>, does
not have any overlapping stops with e<sub><em>m</em></sub> when we attempt to merge, but may have overlapping stops after another 
elevator, e<sub><em>j</em></sub>, has been merged. Therefore, its imperative that we continue to merge all remaining elevators until
each remaining elevator cannot be merged. 

<em>1998 Europe Central Regionals ICPC problem</em>
