MAKE SURE FORMAT > WORD WRAP IS ENABLED BEFORE READING

Before you begin using Rote Less, Play More, there are a couple of things you'll need to do to get the program working properly.

1) Find the folder to where you've downloaded standards.txt (same folder this README should be in.)
2) Copy the file directory into line 14 of UserFxns.java.
3) Add an extra \ before each \ in your file directory.
4) Make sure you have both Run.java and UserFxns.java open, then compile. Then make sure you're on Run.java, hit run, and the program should be working fine!

When you've got the program running, you'll notice that function 5 asks you to enter chords in the format given by README. Here's what that looks like!



CONVENTIAL NAME: CODE NAME

diatonic pitches of relative major scale: 1-7
flat 2, 3, 5, 6, 7: b2, b3, b5, b6, b7

maj: maj
maj7: maj7
dom7: dom
min: min
min7: min7
half dim 7: hd7
full dim 7: fd7
dom7 flat 13: domb13
dom7 flat 9: domb9
minor triad with major 7: minmaj7
min 6: min6
6: 6
7 sus: domsus

one beat: /2
two beats: /2
three beats: /3
four beats: [blank]

Your chords should formatted as the pitch in relation to the key, the code name of the chords, and the number of beats (left blank if 4) for the chord. Separate chords by commas, like a CSV. Open up standards.txt and check out the formatting for help if you're at all confused!

Here's an example for what you might try: 1dom,4dom,1dom,1dom



---



You're also able to add songs yourself into standards.txt. This is totally optional, but handy if you have some of your own songs/notice ones missing that you'd like to be able to use the functions on. The format is as follows:

SONG TITLE
CHORDS

The chords are formatted just like the format key above used during step 5. And if you've got some chord that's not in the key, feel free to make your own notation for it and add it to the key. The program will still let you search for a custom chord!

If you do choose to add more songs, there's one more important thing for you to change. On line 10 of UserFxns.java, edit the number of rows in the masterList array from its current value to the number of songs you now have in standards.txt. If you don't do this step, you will get a null pointer exception or something of the like during runtime!
