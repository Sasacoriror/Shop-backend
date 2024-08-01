#! /bin/bash -x

read -p "Turn featuer on or off (on/off) " answer

while true
do
  if [ "$answer" == "on" ]; then
      value=0
  elif [ "$answer" == "off" ]; then
      value=1
  else
    echo "Enter on or off"
    read -p "Turn featuer on or off (yes/no) " answer
  fi

  read -p "MySql username:" user
  read -p "MySql password:" code

  sql_update="update enabled set enabled_value ='$value' where id=1"
  mysql -u "$user" -p"$code" -D "shop" -e "$sql_update"

  if [ $? -eq 0 ]; then
  message="Black Friday is $answer \nDatabase updated"
  else
  message="Database did not update"
  fi
  msg_toUser=\"$message\"

url=https://discord.com/api/webhooks/1167414077983821906/6soV3lR2TWQlPjournbS10bt5VuldaRmC38Ta2fBBmjzTnkFU4uI3HR4nVBlZdqmsrcJ
curl -H "Content-Type: application/json" -X POST -d "{\"content\": $msg_toUser}" $url

if [ "$value" == 1 ]; then
exit 1
fi

sleep 15
answer="off"

done





