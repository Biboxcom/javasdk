# API SDK

## 1.Httpclient


```
String APIKEY = "apiKey";
String SECRET = "apiSecret" 

//default
//BiBoxHttpClient client = BiBoxClient.ofDefaults();

//api key
BiBoxHttpConfig config = BiBoxHttpConfig
                .custom().host("https://api.bibox365.com")
                .apiKey(apiKey)
                .secret(secret)
                .build();
BiBoxHttpClient client = BiBoxClient.of(config);


//eg
client.ping();
client.pairList();
...
```

## 2.Websocket

```
 public static void main(String[] args) throws URISyntaxException
    {
        String apiKey = "Yours apiKey";
        String secret = "Yours secret";
        String host = "wss://push.bibox365.com/";
        //BiBoxWebSocketClient webSocketClient=BiBoxClient.ofDefaultsWebSocket();
        BiBoxWebSocketConfig config = BiBoxWebSocketConfig.custom().host(host).build();
        BiBoxWebSocketClient webSocketClient = BiBoxClient.ofWebSocket(config);
        webSocketClient.login(apiKey, secret);
        webSocketClient.subChannel(ChannelUtils.getTickerChannel("BTC_USDT"));
        webSocketClient.subChannel(ChannelUtils.getIndexMarket());
        webSocketClient.subChannel(ChannelUtils.getContractPriceLimit());
        webSocketClient.registerMessageHandler(new WebSocketClientEndpoint.MessageHandler()
        {
            @Override
            public void pingPong(String message)
            {
                System.out.println(message);
            }

            @Override
            public void channelMessage(int dataType, String channel, String data)
            {
                System.out.println(String.format("dataType:%d channel:%s %s", dataType, channel, data));
            }

            @Override
            public void error(String message)
            {
                System.out.println(message);
            }
        });
        while (true) {

        }
    }
```

