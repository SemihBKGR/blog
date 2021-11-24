INSERT INTO `website`.`subjects` (`id`, `name`, `explanation`, `url_endpoint`, `image_url`, `display_order`)
VALUES (1, 'subject-01', 'subject-01 explanation', 'subject-01', '/static/image/blue.png', 1),
       (2, 'subject-02', 'subject-02 explanation', 'subject-02', '/static/image/blue.png', 2),
       (3, 'subject-03', 'subject-03 explanation', 'subject-03', '/static/image/blue.png', 3);

INSERT INTO website.categories (`id`, `name`, `explanation`, `image_url`, `display_order`)
VALUES (1, 'category-01', 'category-01 explanation', '/static/image/blue.png', 1),
       (2, 'category-02', 'category-02 explanation', '/static/image/blue.png', 1),
       (3, 'category-03', 'category-03 explanation', '/static/image/blue.png', 1),
       (4, 'category-04', 'category-04 explanation', '/static/image/blue.png', 2),
       (5, 'category-05', 'category-05 explanation', '/static/image/blue.png', 2),
       (6, 'category-06', 'category-06 explanation', '/static/image/blue.png', 2),
       (7, 'category-07', 'category-07 explanation', '/static/image/blue.png', 3),
       (8, 'category-08', 'category-08 explanation', '/static/image/blue.png', 3),
       (9, 'category-09', 'category-09 explanation', '/static/image/blue.png', 3);

INSERT INTO website.posts(`subject_id`, `category_id`, `title`, `brief`, `content`, `url_endpoint`, `image_url`,
                          `display_order`, `create_time`)
VALUES (1, 1, 'post-01', 'post-01 brief', 'post-01 content', 'post-01', '/static/image/blue.png', 1, UNIX_TIMESTAMP()),
       (2, 2, 'post-02', 'post-02 brief', 'post-02 content', 'post-02', '/static/image/blue.png', 1, UNIX_TIMESTAMP()),
       (3, 3, 'post-03', 'post-03 brief', 'post-03 content', 'post-03', '/static/image/blue.png', 1, UNIX_TIMESTAMP()),
       (1, 4, 'post-04', 'post-04 brief', 'post-04 content', 'post-04', '/static/image/blue.png', 1, UNIX_TIMESTAMP()),
       (2, 5, 'post-05', 'post-05 brief', 'post-05 content', 'post-05', '/static/image/blue.png', 1, UNIX_TIMESTAMP()),
       (3, 6, 'post-06', 'post-06 brief', 'post-06 content', 'post-06', '/static/image/blue.png', 1, UNIX_TIMESTAMP()),
       (1, 7, 'post-07', 'post-07 brief', 'post-07 content', 'post-07', '/static/image/blue.png', 1, UNIX_TIMESTAMP()),
       (2, 8, 'post-08', 'post-08 brief', 'post-08 content', 'post-08', '/static/image/blue.png', 1, UNIX_TIMESTAMP()),
       (3, 9, 'post-09', 'post-09 brief', 'post-09 content', 'post-09', '/static/image/blue.png', 1, UNIX_TIMESTAMP()),
       (1, 1, 'post-10', 'post-10 brief', 'post-10 content', 'post-10', '/static/image/blue.png', 2, UNIX_TIMESTAMP()),
       (2, 2, 'post-11', 'post-11 brief', 'post-11 content', 'post-11', '/static/image/blue.png', 2, UNIX_TIMESTAMP()),
       (3, 3, 'post-12', 'post-12 brief', 'post-12 content', 'post-12', '/static/image/blue.png', 2, UNIX_TIMESTAMP()),
       (1, 4, 'post-13', 'post-13 brief', 'post-13 content', 'post-13', '/static/image/blue.png', 2, UNIX_TIMESTAMP()),
       (2, 5, 'post-14', 'post-14 brief', 'post-14 content', 'post-14', '/static/image/blue.png', 2, UNIX_TIMESTAMP()),
       (3, 6, 'post-15', 'post-15 brief', 'post-15 content', 'post-15', '/static/image/blue.png', 2, UNIX_TIMESTAMP()),
       (1, 7, 'post-16', 'post-16 brief', 'post-16 content', 'post-16', '/static/image/blue.png', 2, UNIX_TIMESTAMP()),
       (2, 8, 'post-17', 'post-17 brief', 'post-17 content', 'post-17', '/static/image/blue.png', 2, UNIX_TIMESTAMP()),
       (3, 9, 'post-18', 'post-18 brief', 'post-18 content', 'post-18', '/static/image/blue.png', 2, UNIX_TIMESTAMP()),
       (1, 1, 'post-19', 'post-19 brief', 'post-19 content', 'post-19', '/static/image/blue.png', 3, UNIX_TIMESTAMP()),
       (2, 2, 'post-20', 'post-20 brief', 'post-20 content', 'post-20', '/static/image/blue.png', 3, UNIX_TIMESTAMP()),
       (3, 3, 'post-21', 'post-21 brief', 'post-21 content', 'post-21', '/static/image/blue.png', 3, UNIX_TIMESTAMP()),
       (1, 4, 'post-22', 'post-22 brief', 'post-22 content', 'post-22', '/static/image/blue.png', 3, UNIX_TIMESTAMP()),
       (2, 5, 'post-23', 'post-23 brief', 'post-23 content', 'post-23', '/static/image/blue.png', 3, UNIX_TIMESTAMP()),
       (3, 6, 'post-24', 'post-24 brief', 'post-24 content', 'post-24', '/static/image/blue.png', 3, UNIX_TIMESTAMP()),
       (1, 7, 'post-25', 'post-25 brief', 'post-25 content', 'post-25', '/static/image/blue.png', 3, UNIX_TIMESTAMP()),
       (2, 8, 'post-26', 'post-26 brief', 'post-26 content', 'post-26', '/static/image/blue.png', 3, UNIX_TIMESTAMP()),
       (3, 9, 'post-27', 'post-27 brief', 'post-27 content', 'post-27', '/static/image/blue.png', 3, UNIX_TIMESTAMP());


INSERT INTO posts(subject_id, category_id, title, brief, content, url_endpoint, image_url, create_time)
    VALUE (1, 1, 'test-post', 'test-post', '<h3>subtitle-01</h3>
<p>
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur suscipit neque vel leo convallis iaculis. Aliquam
erat volutpat. Nulla auctor convallis enim eget tincidunt. Nullam maximus lacus porttitor sodales semper. Proin in
varius quam. Vivamus id sodales nulla, a aliquet augue. Donec eget nibh diam. Maecenas fermentum condimentum posuere.
Aenean non diam ornare diam semper molestie at ut metus. Fusce hendrerit augue a arcu semper, id rhoncus elit egestas.
Praesent sed nisl non ex semper tristique sed nec metus.
</p>
<h3>subtitle-02</h3>
<p>
Vestibulum non magna eget mi ornare viverra nec sed turpis. Curabitur id malesuada quam. Praesent eu porttitor neque,
vitae ullamcorper leo. Maecenas ultricies tempor diam pellentesque porta. Sed nibh ante, iaculis id pharetra sit amet,
sollicitudin a sapien. Cras eget neque augue.
<img src="/static/image/blue.png">
Proin suscipit eleifend neque at viverra. Pellentesque ac eros tincidunt,
faucibus elit nec, bibendum nibh. Proin pharetra suscipit mollis. Praesent dapibus auctor accumsan. Aliquam iaculis
quis odio ac vulputate. Quisque vestibulum dolor leo, in ultrices libero scelerisque ac. Pellentesque feugiat risus in
est fermentum facilisis. Vivamus cursus ultrices nibh et elementum.
</p>
<h3>subtitle-03</h3>
<p>
Integer et felis leo. Suspendisse pharetra, nisl vel ultricies vulputate, dui dui eleifend nisi, sed hendrerit magna
magna at diam. Proin nulla metus, ultricies vel lacus vitae, pharetra hendrerit tellus. Aenean commodo felis consequat
metus vehicula, sit amet iaculis tortor cursus.
<img src="/static/image/blue.png">
Sed pharetra, urna et hendrerit porttitor, augue libero consectetur
erat, a tincidunt urna orci ac justo. Praesent quis tincidunt tortor. Etiam convallis tincidunt blandit. Donec vel
rutrum massa. In tempor ullamcorper felis eu gravida.
</p>
<h3>subtitle-04</h3>
<p>
Fusce pulvinar ligula sit amet consequat aliquam. Duis facilisis ultricies elit ut commodo. Pellentesque et nibh sit
amet nulla viverra congue ut eget augue.
<pre><code class="language-java">
@SpringBootApplication(proxyBeanMethods = false)
public class WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

}
</code></pre>
Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
inceptos himenaeos. Morbi vel pulvinar nisl, sit amet pretium libero. Donec ac laoreet lorem, quis imperdiet ligula.
Aliquam nec leo mattis dui cursus ultrices. Vestibulum venenatis tellus massa, pellentesque sagittis justo gravida
eget. Suspendisse potenti.
</p>
<h3>subtitle-05</h3>
<p>
Vivamus at metus quam. Curabitur eu tortor ac est tempor commodo et id nisi. Nam iaculis nunc et dui finibus tempor.
Maecenas id consequat metus. Sed finibus, neque vitae luctus cursus, erat neque mollis odio, a auctor ex mi eget dui.
Fusce accumsan nunc sit amet neque tincidunt, at varius mi fermentum. Nunc mollis nec lorem in maximus. Maecenas
convallis justo et sapien egestas, quis luctus mi bibendum.
<img src="/static/image/blue.png">
Vivamus felis mi, molestie aliquet convallis in, convallis
rutrum purus. Phasellus vulputate libero augue, id blandit lectus vulputate a. Ut placerat porttitor porta. Cras vitae
magna vitae arcu imperdiet feugiat dapibus hendrerit enim.
</p>
<h3>subtitle-06</h3>
<p>
Praesent in lorem leo. Fusce libero enim, blandit vel feugiat id, volutpat ac nisi. Mauris dapibus, metus vitae dictum
sodales, ligula nisi imperdiet ante, et hendrerit nunc metus eu mi.
<pre><code class="language-java">
@SpringBootApplication(proxyBeanMethods = false)
public class WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

}
</code></pre>
Interdum et malesuada fames ac ante ipsum primis in
faucibus. Nam pharetra, justo elementum dignissim auctor, augue ligula pulvinar magna, eu placerat lectus orci et diam.
Nulla egestas purus et augue vehicula cursus. Pellentesque habitant morbi tristique senectus et netus et malesuada
fames ac turpis egestas. Praesent pretium facilisis sagittis.
</p>
<h3>subtitle-07</h3>
<p>
Vestibulum tempor sagittis orci, vitae sodales odio rhoncus vitae. Duis sagittis pretium vehicula. Praesent ut dolor
eu nibh mattis eleifend sed in nunc. Fusce sit amet mi massa. Sed scelerisque purus non turpis hendrerit auctor. Donec
suscipit, tortor sit amet gravida fringilla, ipsum arcu pulvinar leo, vitae ultrices diam orci nec mi. Maecenas mattis
placerat turpis a tristique. Nam et massa non erat finibus elementum. Aliquam erat volutpat. In consequat arcu sed
lacus viverra ullamcorper.
<pre><code class="language-java">
@SpringBootApplication(proxyBeanMethods = false)
public class WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

}
</code></pre>
Pellentesque congue, erat vel volutpat luctus, purus dolor consequat tellus, sed ullamcorper
lectus ante in dui. Morbi libero nibh, ornare eu finibus nec, aliquam eu elit. Vestibulum aliquet dolor ac auctor auctor.
Cras sed pulvinar purus, a ornare nisi. Integer sagittis a augue quis malesuada. Sed at tempus velit. Quisque molestie,
nisi vel iaculis luctus, dolor ipsum dapibus quam, non euismod urna nisi eu purus. Quisque ultrices placerat sodales.
Sed commodo neque id mauris varius, vitae vestibulum mauris aliquam.
<img src="/static/image/blue.png">
Pellentesque in quam quis nisl cursus scelerisque
vitae a justo. Ut ac nisl non ligula aliquam malesuada. Proin sit amet lacinia neque, quis posuere nibh. Orci varius
natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi non dapibus nunc. Sed pulvinar, ante
in elementum sollicitudin, est eros aliquam arcu, non egestas dui odio ut eros. Praesent porta, sem ac iaculis
efficitur, ipsum risus venenatis libero, sit amet mattis arcu velit quis dui. Praesent fermentum nunc quis nulla
dapibus, et ullamcorper eros ullamcorper.
</p>
<h3>subtitle-08</h3>
<p>
Suspendisse at augue pretium, euismod lacus imperdiet, vehicula orci. Etiam nec interdum lorem, vel interdum sem.
Suspendisse enim nisl, efficitur a turpis eget, gravida mollis ipsum. In tempus tincidunt lorem, tincidunt bibendum
erat congue nec. Proin nulla arcu, viverra mollis sem ac, eleifend luctus lacus. Nunc vitae felis vehicula orci euismod
vulputate. Suspendisse porttitor volutpat pharetra. Nullam id nulla non lectus pellentesque lacinia ut vitae metus.
Suspendisse potenti. Mauris et euismod risus. Cras in diam quis justo molestie suscipit convallis sed nunc.
Aliquam eget ex justo. Proin scelerisque bibendum quam ac sagittis.
<pre><code class="language-java">
@SpringBootApplication(proxyBeanMethods = false)
public class WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

}
</code></pre>
Vivamus lobortis egestas convallis. In at mollis
risus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Suspendisse viverra
ante in vulputate aliquet. Mauris finibus, leo at gravida varius, nunc ligula scelerisque nisl, a volutpat mauris magna
in neque. Nullam ultrices leo nec orci auctor pellentesque. Aliquam gravida ex eros, eget scelerisque erat aliquam non.
Nulla ut magna a diam consectetur blandit mollis eu velit. Aenean quis sem quis urna scelerisque condimentum quis vitae
odio. Cras porttitor purus quis varius tempor. Donec tellus urna, mattis eu nulla quis, sodales pulvinar arcu. Nullam
rutrum nulla id iaculis posuere.
</p>
<h3>subtitle-09</h3>
<p>
Suspendisse at augue pretium, euismod lacus imperdiet, vehicula orci. Etiam nec interdum lorem, vel interdum sem.
Suspendisse enim nisl, efficitur a turpis eget, gravida mollis ipsum. In tempus tincidunt lorem, tincidunt bibendum
erat congue nec. Proin nulla arcu, viverra mollis sem ac, eleifend luctus lacus. Nunc vitae felis vehicula orci euismod
vulputate. Suspendisse porttitor volutpat pharetra. Nullam id nulla non lectus pellentesque lacinia ut vitae metus.
Suspendisse potenti. Mauris et euismod risus. Cras in diam quis justo molestie suscipit convallis sed nunc.
Aliquam eget ex justo. Proin scelerisque bibendum quam ac sagittis. Vivamus lobortis egestas convallis. In at mollis
risus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Suspendisse viverra
ante in vulputate aliquet. Mauris finibus, leo at gravida varius, nunc ligula scelerisque nisl, a volutpat mauris magna
in neque. Nullam ultrices leo nec orci auctor pellentesque. Aliquam gravida ex eros, eget scelerisque erat aliquam non.
Nulla ut magna a diam consectetur blandit mollis eu velit. Aenean quis sem quis urna scelerisque condimentum quis vitae
odio. Cras porttitor purus quis varius tempor. Donec tellus urna, mattis eu nulla quis, sodales pulvinar arcu. Nullam
rutrum nulla id iaculis posuere.
</p>', 'Cras in diam quis justo molestie suscipit convallis sed nunc.
Aliquam eget ex justo. Proin scelerisque bibendum quam ac sagittis. Vivamus lobortis egestas convallis. In at mollis
risus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Suspendisse viverra
ante in vulputate aliquet. Mauris finibus, leo at gravida varius, nunc ligula scelerisque nisl, a volutpat mauris magna
in neque. Nullam ultrices leo nec orci auctor pellentesque. Aliquam gravida ex eros, eget scelerisque erat aliquam non.
Nulla ut magna a diam consectetur blandit mollis eu velit. Aenean quis sem quis urna scelerisque condimentum quis vitae
odio. Cras porttitor purus quis varius tempor. Donec tellus urna, mattis eu nulla quis, sodales pulvinar arcu. Nullam
rutrum nulla id iaculis posuere.', '/static/image/blue.png', UNIX_TIMESTAMP()
    )
