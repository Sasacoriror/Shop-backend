#! /bin/bash

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

  exit 1
done





