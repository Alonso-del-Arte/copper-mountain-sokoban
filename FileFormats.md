# File formats

The two main file formats for representing Sokoban levels are both 
human-readable. Both formats use the symbols described in [the notation 
document](Notation.md).

## The plaintext (*.sok) format

Files in this format begin with a very distinctive header. Here I quote only the 
first five lines.

```
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::         Sokoban (c) by Falcon Co., Ltd., Japan         ::
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::                    File Format 0.17                    ::
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
```

A double colon at the beginning of the line indicates a comment not meant to be 
processed by the Sokoban program. A lot of helpful information follows, 
including the following remarks:

> The first and the last non-empty square in each row must be a wall or a box on 
a goal. An empty interior row is written with at least one "-" or "_".

> Boards may be run-length encoded (RLE), e.g., "###----p.#" may be encoded as 
"3#4-p.#", and "#-#-#-##-#-#-#" may be encoded as "2(3(#-)#)". A row cannot be 
split over multiple lines.

> Rows may be combined on a single line by using "|" as a row separator, e.g., 
"--3#|3#-#|#pb.#|5#". A "|" at the end of a line is optional and may be omitted.

After that preamble, there should follow these fields:

* Date created
* Date of last change
* Author name
* Collection name

[FINISH WRITING]

## The SLC (*.slc) format

The Sokoban Level Collection (SLC) format is an XML format. However, I haven't 
been able to find the document type definition (DTD) anywhere.

[FINISH WRITING]
