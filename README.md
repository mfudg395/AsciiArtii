# AsciiArtii

AsciiArtii is a simple Java tool run on the command line that converts ASCII art to a .png image. ASCII art can be loaded from a file and is saved in 
a couple formats; either as a .png image, or as a .hex file.

This was an assignment that I worked on during my first semester at Mount Royal. The iteration here is an attempt at improveing what I worked on
during the early days.

## Features

AsciiArtii can load any ASCII art stored in a .txt file that's placed in the `ascii-art-files` folder. When loading an ASCII art file, it will also load
a corresponding .map file, if one can be found in `color-map-files`. A `.map` file assigns characters used in an ASCII art to a hex color code, so that
you can have some color if you choose to save an image of your ASCII art. `.map` files must be formatted as follows...

```
X #FFFFFF
Y #FFFFFF
Z #FFFFFF
```

...where X/Y/Z are any characters used in the ASCII art, and #FFFFFF is any hex color code. Each line follows that format, and is for a different character/color 
pairing.

AsciiArtii can then save your ASCII art as an image or a hex file. A `.hex` file will simply be a representation of the ASCII art where each character is replaced
with it's corresponding hex color code from the `.map`. A `.png` will be an image of the file, with it's characters will be replaced with their respective mapped
colors. An example output of both of these can be found in `generated-hexcolor-files` and `generated-png-files`.