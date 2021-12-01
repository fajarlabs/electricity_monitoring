# electricity_monitoring
Rangkaian dan aplikasi untuk monitoring listrik jarak jauh.

<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/design-architecture.jpg?raw=true" width="700" height="600" /><br />

# Backend
<h5>Hosting</h5>
<b> Menggunakan hosting www.dewaweb.com </b>
<h5> Rest-API untuk menyimpan data R,S,T, Temperature & Humidity </h5>
<b>http://emon.fajarlabs.com/?act=add&r=0&s=0&t=0&temperature=0&humidity=0</b><br />
<b> Response : </b><br />

```
{
    "success": true,
    "response": "The request was successfully completed.",
    "code": 200
}
```

<h5> Rest-API untuk mengambil data terbaru </h5>
<b>http://emon.fajarlabs.com/?act=get</b><br />
<b> Response : </b><br />

```json

{"success":true,"response":{"r":"1","s":"0","t":"0","temperature":"30","humidity":"71"},"code":200}

```

# Environment
<b>PHP version 7.3</b><br />
<b>XAMPP Software</b>

# Files

```
index.php
```

# How to Wifi setup on Raspberry-pi

<h5>Login</h5>
Ketikan di terminal CMD / putty
ssh pi@[hostname / ip]<br /><br />
User : <b>pi</b><br />
Pass : <b>raspberry</b><br /><br />

<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss1.png?raw=true" width="700" height="400" /><br />
<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss2.png?raw=true" width="700" height="400" /><br />
<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss3.png?raw=true" width="700" height="400" /><br />
<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss4.png?raw=true" width="700" height="400" /><br />
<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss5.png?raw=true" width="700" height="400" /><br />

# How to run file using crontab
<b>CMD</b><br />

```
crontab -e
```

lalu tambahkan skrip dibawah ini :

```
@reboot python /home/pi/skripsi/app.py
```

# Android Apps
waiting..


<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss_crontab.png?raw=true" width="700" height="400" /><br />
