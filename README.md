# electricity_monitoring
Rangkaian dan aplikasi untuk monitoring listrik jarak jauh.

<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/design-architecture.jpg?raw=true" width="700" height="600" /><br />

# Backend
<h5> Rest-API untuk menyimpan data R,S,T, Temperature & Humidity </h5>
<b>http://emon.fajarlabs.com/?act=add&r=0&s=0&t=0&temperature=0&humidity=0</b><br />
<h5> Rest-API untuk mengambil data terbaru </h5>
<b>http://emon.fajarlabs.com/?act=get</b><br />
```json
{"success":true,"response":{"r":"1","s":"0","t":"0","temperature":"30","humidity":"71"},"code":200}
```

# Environment
<b>PHP version 7.3</b>
<b>XAMPP Software</b>

# Files
<b>index.php</b>

# How to Wifi setup on Raspberry-pi
<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss1.png?raw=true" width="700" height="400" /><br />
<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss2.png?raw=true" width="700" height="400" /><br />
<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss3.png?raw=true" width="700" height="400" /><br />
<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss4.png?raw=true" width="700" height="400" /><br />
<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss5.png?raw=true" width="700" height="400" /><br />

# How to run file using crontab
<b>crontab -e</b><br />
<img src="https://github.com/fajarlabs/electricity_monitoring/blob/master/screen-capture/ss_crontab.png?raw=true" width="700" height="400" /><br />
