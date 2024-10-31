<? 
$page_title = 'Positioning | CSCI 270'; 

$Positioning = true;
?>
<? require '../../templates/site_header.php'; ?>
<style type="text/css">

/****************************************************************************************************
Styles for the structure of this worksheet
****************************************************************************************************/
html {
    overflow-x: hidden;
}

.greybg {
    padding: 5px;
    border: 1px solid #000;
    background-color: #DDD;
}

#worksheet_page_wrapper {    /* Same size as browser viewport */
    position: relative;
    z-index: 0; /* Forces all blocks in this worksheet into the same stack context of the worksheet_page_wrapper
                    so nothing will end up behind static content in your SSI header/footer course page
                    design when you wrap that around this worksheet. */
}

#worksheet_page_wrapper fieldset {
    margin: 0px 5px 15px 0px;  /*TRBL*/
    border-color: #009;
    min-height: 50px;
}

#worksheet_page_wrapper legend {
    text-align: left;
    font-weight: bold;
    color: #009;
}

span.section_title {
    font-weight: bold;
    text-align: left;
}

section.question {
    margin: 0px 5px 5px 0px;  /*TRBL*/
    border-top: 1px dotted #000;
    background-color: #FFF;
    text-align: left;
}

section.answer {
    margin: 0px 5px 0px 10px;  /*TRBL*/
    background-color: #FFF;
    color: #009;
    text-align: left;
}

/****************************************************************************************************
Styles for the Parent/Child Absolute Position Example
****************************************************************************************************/
#parent {
    margin: auto;
    width: 500px;
    height: 200px;
}

#child {
    position: absolute;
    top: 300px;
    left: 500px;

    height: 100px;
    width: 100px;
}

#parent2 {
    margin: auto;
    width: 500px;
    height: 200px;
    position: relative; /* Key change for relative positioning */
}

#child2 {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);  /* Center positioning */
    height: 100px;
    width: 100px;
}

/****************************************************************************************************
Styles for the Top/Bottom Relative Position Example
****************************************************************************************************/
div.top {
    position: relative;
    top: -10px;
    width: 300px;
    height: 75px;
    z-index: -1;
}

#bottom1 {
    width: 300px;
    height: 75px;
    position: relative;
    top: -50px;
    left: 20px;
    z-index: -2;
}

#bottom2 {
    width: 300px;
    height: 75px;
    top: -50px;
    left: 20px;
}

/****************************************************************************************************
Styles for the Four Absolute Positioned Blocks Example
****************************************************************************************************/
#absolute_wrapper {
    position: relative;
    min-height: 200px;
}

#absolute1 {
    position: absolute;
    top: 50px;
    left: 50px;

    width: 75px;
    height: 75px;
}

#absolute2 {
    position: absolute;
    top: 100px;
    left: 100px;

    width: 75px;
    height: 75px;
}

#absolute3 {
    position: absolute;
    top: 50px;
    left: 250px;

    width: 75px;
    height: 75px;
}

#absolute4 {
    position: absolute;
    top: 100px;
    left: 100px;

    width: 75px;
    height: 75px;
}

/****************************************************************************************************
Styles for the Child Stacking Example
****************************************************************************************************/

#parentA {
    position: relative;
    z-index: 1;
    height: 200px;
}

#parentB {
    position: relative;
    z-index: 2;
    height: 200px;
}

#childA {
    position: relative;
    z-index: 100;
    top: 15px;
    left: 100px;

    height: 100px;
    width: 100px;
}

#childB {
    position: relative;
    z-index: 50;
    top: -200px;
    left: 110px;

    height: 100px;
    width: 100px;
}

.fixed-block {
    position: fixed;
    width: 100px;
    height: 100px;
    padding: 10px;
    text-align: center;
    }

.fixed-block.left {
    top: 1px;
    left: 1px;
    background-color: red;
    color: white;
}

.fixed-block.right {
    bottom: 1px;
    right: 1px;
    background-color: blue;
    color: white;
}

.absolute-block {
    position: absolute;
    width: 100px;
    height: 100px;
    padding: 10px;
    text-align: center;
    background-color: green;
    color: white;
    top: 300px;
    right: -50px;
}

</style>

</head>

<body>
<div id="worksheet_page_wrapper">

<fieldset>
    <legend>Task 1</legend>
    Place two small <i>fixed</i> positioned blocks in this page.  Fix one to the left side of the browser's viewport near the top and one to the right of the viewport near the bottom. Make both blocks smallish with fixed dimensions (100x100 or whatever), give them background colors so they stand out clearly in the page, and put a brief explanation inside each one so I can tell at a glance which blocks they are.

    <div class="fixed-block left">Q1 Left-Top Block</div>
    <div class="fixed-block right">Q1 Right-Buttom Block</div>
</fieldset>

<fieldset>
    <legend>Task 2</legend>
    Place a small <i>absolutely</i> positioned block on the right side of this page, about 300px down from the top.  But only about 1/2 of the block is actually visible on the page, the other half being outside the browser's viewport. Make the block smallish with fixed dimensions (100x100 or whatever), give it a background color so it stands out clearly in the page, and put a brief explanation inside it.

    <div class="absolute-block">Q2 Half Visible</div>
</fieldset>

<br>
<section class="question">The parent and child blocks below are for Question 1.</section>

<div id="parent" class="greybg">
    Parent block
    <div id="child" class="greybg">
    Child Block
    </div>
</div>

<span class="section_title">Question 1</span>
<section class="question">
    Resize the browser window horizontally (drag the lower right corner left and right) and observe that the above parent block moves back and forth since it is centered in the viewpoort. Even though the child block is inside the parent, and positioned absolutely, it doesn't move with the parent. Explain why.
    <section class="answer">
    The child element stays put even when its parent moves because it's positioned absolutely relative to the viewport, not the parent.
    </section>
</section>

<br>

<fieldset>
    <legend>Task 3</legend>
    Below this block, make a second copy of the above example with id values <i>parent2</i> and <i>child2</i> so that the child block always stays inside the parent and at the same location, roughly in the middle of the parent block.  <b>The child block must still have position:absolute.</b>
    <div id="parent2" class="greybg">
    Parent block 2
    <div id="child2" class="greybg">
        Child Block 2
    </div>
    </div>
</fieldset>


<!--************************************************************************************-->
<br>
<section class="question">&nbsp;</section>

The Top and Bottom blocks below are for Questions 2 and 3.
<div class="top  greybg">
    Top block
</div>
<div id="bottom1"  class="greybg">
    Bottom 1 block
</div>

These blocks also go with Questions 2 and 3.
<div class="top  greybg">
    Top block
</div>
<div id="bottom2"  class="greybg">
    Bottom 2 block
</div>

<br>

<span class="section_title">Question 2</span>
<section class="question">
    There are two top/bottom block examples above with <i>almost</i> identical styles.  Why is the bottom2 block not move upward, but the bottom1 block is? Both bottom blocks have the exact same top/left coordinates set in the CSS.
    <section class="answer">
    Even though both bottom blocks have identical styles, #bottom2 doesn't move up because of the stacking context. Since they both have position: relative, they create separate contexts.  The order they appear in the HTML code determines who gets positioned first.  #bottom1 appears first, so it visually takes up the space at top: -50px; left: 20px;, pushing #bottom2 behind it. We can use z-index to control it.
    </section>
</section>

<span class="section_title">Question 3</span>
<section class="question">
    What causes all the extra space you can see below the Bottom 1 block?
    <section class="answer">
    Even though the 'position: relative' on the "Bottom 1" block moves it visually, the empty space it would normally occupy (75px tall by its width) is still reserved in the layout. This creates the 75px gap you see between the bottom of the "Top" block and the element following "Bottom 1".
    </section>
</section>

<br>

<fieldset>
    <legend>Task 4</legend>
    Alter the above example (Top/Bottom Blocks) as follows <b>without changing the HTML code</b>, just the CSS.
    <br>
    a) Tweak the top blocks by moving them both up exactly 10 pixels. That should make the top blocks cover up about half of the sentences above them.
    <br>
    b) Make the Top blocks render behind the sentences above them (so that the text is on top of the top blocks).
    <br>
    c) Make Bottom 1 block stack underneath its Top block.
</fieldset>

<br>

<!--************************************************************************************-->
<br>
<section class="question">The Absolute blocks below are for Questions 4, 5, and 6.</section>
<div id="absolute_wrapper">

    <div id="absolute1" class="greybg">
    Absolute 1
    </div>
    <div id="absolute2" class="greybg">
    Absolute 2
    </div>

    <div id="absolute3" class="greybg">
    Absolute 3
    <div id="absolute4" class="greybg">
        Absolute 4
    </div>
    </div>

</div>

<br>
<br>
<br>

<span class="section_title">Question 4</span>
    <section class="question">
    Absolute1 and Absolute3 have identical styles, except that Absolute3 is 200px more to the right.  Absolute2 and Absolute4 have exactly identical styles.  Explain why Absolute2 and Absolute4 are positioned differently.  Explain precicely.
    <section class="answer">
        Absolute2 and Absolute4 have the same styles but appear differently because of absolute positioning within a relative container. They're both positioned relative to the top-left corner of their shared container (#absolute_wrapper). Absolute1 and Absolute3 (with identical styles to Absolute2) might be overlapping Absolute2 in the stacking context, pushing it down to avoid that overlap. If we remove Absolute1 and Absolute3, Absolute2 and Absolute4 would appear in the same spot. 
    </section>
    </section>

    <br>

    <span class="section_title">Question 5</span>
    <section class="question">
    What happens if the styles for the absolute_wrapper are removed (just remove the id value)? Same thing happens if you completely remove the absolute_wrapper block itself.  Explain precicely.
    <section class="answer">
        Removing the absolute_wrapper or its styles messes up the absolute element positioning. Without a relative container (position: relative), the elements (Absolute1, etc.) lose their reference point and are positioned relative to the viewport instead. This means they'll all be positioned relative to the top-left corner of the browser window, potentially causing stacking and unexpected behavior.
    </section>
    </section>

    <br>

    <span class="section_title">Question 6</span>
    <section class="question">
    Absolute2 is on top of Absolute 1.  What is determining that stacking order?
    <section class="answer">
        Since both are absolutely positioned within the same container, the order they appear in the HTML code matters. The element earlier in the code gets positioned first and potentially claims the specified top value. Absolute2, coming later, might be shifted down slightly to avoid overlapping Absolute1, making it appear "on top" visually.
    </section>
    </section>

    <br>


    <section class="question">The parent and child blocks below are for Question 7.</section>

    <div id="parentA" class="greybg">
    Parent A block
    <div id="childA" class="greybg">
        Child A Block
    </div>
    </div>

    <br>

    <div id="parentB" class="greybg">
    Parent B block
    <br><br>
    Child B is actually a child of this block, it's just positioned outside of it.
    <div id="childB" class="greybg">
        Child B Block
    </div>
    </div>

    <br>

    <span class="section_title">Question 7</span>
    <section class="question">
    The child A block above has z-index of 100 and child B has z-index of 50.  So it seems that child A should be stacked on top of child B.  Why is it not?
    <section class="answer">
        Child B appears on top even though Child A has a higher z-index (100) because z-index only works within stacking contexts.  Both children are positioned relatively, creating separate contexts.  Child B's z-index of 50 only matters within its own context (parentB) where it has the highest value. Child A's z-index of 100 is in a separate context (parentA) and doesn't affect Child B visually.
    </section>
    </section>
</div>
<? require '../../templates/site_footer.php'; ?>
