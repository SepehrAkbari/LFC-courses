<? 
$page_title = 'Lists | CSCI 270'; 

$li_1 = 'na';
$li_2 = 'active_nav';
$li_3 = 'na';
$li_4 = 'na';
$li_5 = 'na';
?>
<? require '../../templates/site_header.php'; ?>
<style>
    #ver{
        border: 2px solid #8f0808;
        padding: 20px;
    }
    #ver li {
        border: 2px solid #0f61b8;
        margin: 10px;
    }
    #hor{
        border: 2px solid #8f0808;
        padding-top: 7px;
        height: 30px;
    }
    #hor li{
        border: 2px solid #0f61b8;
        margin-right: 30px;
        float: left;
        padding: 1px;
    }
    #navi{
        list-style-type: none;
        display: block;
    }
    #navi li a{
        color: #003771;
        float: left;
        margin-right: 10px;
        border: 2px solid #0f61b8;
        background-color: #8bbaed;
        padding: 20px;
    }

    #navi a:link, #navi a:visited{
        color: #003771;
        text-decoration: none;
    }

    #navi a:active, #navi a:hover{
        background-color: #8f0808;
        color: #fff;
        text-decoration: underline;
    }
</style>

<div>
    <h3>Experiment #1:</h3>
    <ul id="ver">
        <li>Dog</li>
        <li>Cat</li>
        <li>Bird</li>
        <li>Fish</li>
    </ul>
    <br>
    <h3>Questions:</h3>
    <ol>
        <li>Notice the relatively large left indentation of the list (the extra space to the left of the bullets). Precisely which CSS property(s) is creating that indentation: padding/margin of the ul or li blocks?
            <ul>
                <li>The relatively large left indentation of the list is usually caused by the <b>padding property</b> of the &lt;ul&gt; block.</li>
            </ul>
        </li>
        <br>
        <li>What CSS property is appropriate to adjust the vertical space between the list items to make the list more or less compact?
            <ul>
                <li>The appropriate CSS property to adjust the vertical space between list items is the <b>margin property.</b></li>
            </ul>
        </li>
        <br>
        <li> What CSS property can you use to change where the bullets are drawn relative to the borders of the li blocks? (Hint: It’s not one you already know like padding or margin. So do some research.)
            <ul>
                <li>To change where the bullets are drawn relative to the borders of the &lt;li&gt; blocks, we can use the CSS <b>list-style-position property</b>. This property allows us to control the position of the bullet marker using the inside and outside values.</li>
            </ul>
        </li>
    </ol>
    <br>
    <h3>Experiment #2:</h3>
    <ul id="hor">
        <li>Dog</li>
        <li>Cat</li>
        <li>Bird</li>
        <li>Fish</li>
    </ul>
    <br>
    <h3>Questions:</h3>
    <ol>
        <li>How did you fix the collapsing border of the parent ul block problem?
            <ul>
                <li>Using the height property. Basically, set the height manually instead of having it manipulated by css.</li>
            </ul>
        </li>
    </ol>
    <br>
    <ul id="navi">
        <li><a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ" target="_blank">Dog</a></li>
        <li><a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ" target="_blank">Cat</a></li>
        <li><a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ" target="_blank">Bird</a></li>
        <li><a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ" target="_blank">Fish</a></li>
    </ul>
    <div class="clear_float"></div>
    <br><br>
</div>

<? require '../../templates/site_footer.php'; ?>
