# 【β版】Spring boot App

javaアプリケーションは./app直下に作成してください。

とりあえず「docker-compose up」で動くと思います。
アプリケーションはapp配下で開発してください。
docker起動中でもファイルを編集すれば自動リロードされるはず

止めるときは「docker-compose stop」もしくは「docker-compose down」で。

http://localhost うまくいかなければ http://127.0.0.1 でアクセス。
「curl -F "message=好きなメッセージ" http://localhost/」でデータを追加できます。