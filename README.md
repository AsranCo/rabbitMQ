<div class="header reader-header reader-show-element">
<h1 class="reader-title" dir="ltr"><strong>RabbitMQ Exchange Types , Bindings, Routing Keys | RabbitMQ Tutorial</strong></h1>

<div class="credits reader-credits" dir="ltr">&nbsp;</div>
</div>

<hr />
<div class="content">
<div class="moz-reader-content line-height4 reader-show-element">
<div class="page" id="readability-page-1">
<div>
<p dir="ltr"><strong><span>Exchanges are message routing agents, which are defined per virtual host within the rabbitMQ system.&nbsp;When&nbsp;program/application (Known as Producer) connect to RabbitMQ server to publish a message, it first sends the&nbsp;message to an exchange. After&nbsp;receiving a message, exchange&nbsp;routes them to different message queues&nbsp;with help of header attributes, bindings, and routing keys.&nbsp;It should be noted that messages are not published directly to a queue, instead, it is first send to an exchange and then exchange routes them to different message queues.</span></strong></p>

<p dir="ltr"><strong><span>Binding :- It is a link between a queue and an exchange.</span></strong></p>

<p dir="ltr"><strong><span>Routing key :- It is a&nbsp;message attribute&nbsp;that the exchange can looks&nbsp;at, to decide how to route the message to queues. The routing key is like an address<i>&nbsp;</i>for the message.</span></strong></p>

<p dir="ltr"><strong><img alt="" data-rich-file-id="1" src="/system/rich/rich_files/rich_files/000/000/001/original/Exchange_2.png" /></strong></p>

<p dir="ltr"><strong><span>Exchanges, connections and queues can be configured with parameters such as durable, temporary, and auto delete&nbsp;during&nbsp;creation.</span></strong></p>

<ol dir="ltr">
	<li><strong><span>Durable Exchange :- It&nbsp;will survive server restarts and will last until they are explicitly deleted.&nbsp;</span></strong></li>
	<li><strong><span>Temporary Exchanges :-&nbsp;It&nbsp;will&nbsp;exist until RabbitMQ is shutdown.</span></strong></li>
	<li><strong><span>Auto Deleted Exchanges :- It will exist till&nbsp;the last bound object unbound from the exchange.</span></strong></li>
</ol>

<p dir="ltr"><strong><span>User can create their own exchanges or use the predefined default exchanges, default exchanges are created when the server starts for the first time.</span></strong></p>

<h2 dir="ltr"><strong><span>RabbitMQ Exchange Types :-</span></strong></h2>

<p dir="ltr"><strong><span>RabbitMQ provide four different types of exchange, each differ in the way they route messages to the queues. Brief explanation about each of them are as follows :-</span></strong></p>

<ol dir="ltr">
	<li><strong><span><span style="color:#c0392b;"><span style="font-size:16px;">Direct Exchange</span></span> :- A direct exchange routes messages to queues based on message routing key.&nbsp;The routing key is a message attribute&nbsp;in the message header added by the producer. The default exchange for direct exchange is &ldquo;amq.direct&ldquo;. For detailed explanation and code example, you can visit <span><a href="https://codedestine.com/rabbitmq-direct-exchange/" target="_blank">RabbitMQ &ndash; Direct Exchange</a></span>.</span></strong></li>
	<li><strong><span><span style="color:#d35400;"><span style="font-size:16px;">Topic Exchange</span></span> :-&nbsp;A topic&nbsp;exchange route messages to queues based on the wildcard match between routing key and routing pattern specified during the binding of the queue. The default exchange for topic&nbsp;exchange is &ldquo;amq.topic&ldquo;.&nbsp;For detailed explanation and code example, you can visit <span><a href="https://codedestine.com/rabbitmq-topic-exchange/" target="_blank">RabbitMQ &ndash; Topic&nbsp;Exchange</a></span>.</span></strong></li>
	<li><strong><span><span style="color:#d35400;"><span style="font-size:16px;">Fanout Exchange</span></span> :-&nbsp;A fanout exchange copies the message and routes it to all the queues bound to it. The default exchange for fanout&nbsp;exchange is &ldquo;amq.fanout&ldquo;. For detailed explanation and code example, you can visit <span><a href="https://codedestine.com/rabbitmq-fanout-exchange/" target="_blank">RabbitMQ &ndash; Fanout&nbsp;Exchange</a></span>.</span></strong></li>
	<li><strong><span><span style="color:#d35400;"><span style="font-size:16px;">RPC Exchange</span></span> :</span></strong></li>
</ol>

<p dir="ltr"><strong><span>That&rsquo;s all for RabbitMQ Exchange Types, Bindings and Routing Keys, If you liked it, please share your thoughts in comments section and share it with others too.</span></strong></p>
</div>
</div>
</div>
</div>
