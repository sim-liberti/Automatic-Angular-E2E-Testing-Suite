## AREA 1:

### TC-SIDE-01/TC-SIDE-02:
- Link Home
  - Absolute: "/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[1]/a"
  - Hook: "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][1]//*[@x-test-hook-a-5]"
  - Katalon: "(.//*[normalize-space(text()) and normalize-space(.)='Search'])[1]/preceding::a[1]"
  - Relative: "//a[normalize-space()='Home']"
  - RobulaPlus:
  - Robula:
  - Selenium: "//a[contains(text(),'Home')]"
- Link Search  
  - Absolute: "/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[2]/a"
  - Hook: "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][2]//*[@x-test-hook-a-5]"
  - Katalon: "(.//*[normalize-space(text()) and normalize-space(.)='Home'])[1]/following::a[1]"
  - Relative: "//a[normalize-space()='Search']"
  - RobulaPlus:
  - Robula:
  - Selenium: "//a[contains(text(),'Search')]"
- Link Browse
  - Absolute: "/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[3]/a"
  - Hook: "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][3]//*[@x-test-hook-a-5]"
  - Katalon: "(.//*[normalize-space(text()) and normalize-space(.)='Search'])[1]/following::a[1]"
  - Relative: "//a[normalize-space()='Browse']"
  - RobulaPlus:
  - Robula:
  - Selenium: "//a[contains(text(),'Browse')]"
- Link MyPlaylists
  - Absolute: "/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[4]/a"
  - Hook: "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][4]//*[@x-test-hook-a-5]"
  - Katalon: "(.//*[normalize-space(text()) and normalize-space(.)='Browse'])[1]/following::a[1]"
  - Relative: "//a[normalize-space()='My Playlists']"
  - RobulaPlus:
  - Robula:
  - Selenium: "//a[contains(text(),'My Playlists')]"
- Link MyAlbums
  - Absolute: "/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[5]/a"
  - Hook: "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][5]//*[@x-test-hook-a-5]"
  - Katalon: "(.//*[normalize-space(text()) and normalize-space(.)='My Playlists'])[1]/following::a[1]"
  - Relative: "//a[normalize-space()='My Albums']"
  - RobulaPlus:
  - Robula:
  - Selenium: "//a[contains(text(),'My Albums')]"
- Link LikedSongs
  - Absolute: "/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[6]/a"
  - Hook: "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][6]//*[@x-test-hook-a-5]"
  - Katalon: "(.//*[normalize-space(text()) and normalize-space(.)='My Albums'])[1]/following::a[1]"
  - Relative: "//a[normalize-space()='Liked songs']"
  - RobulaPlus:
  - Robula:
  - Selenium: "//a[contains(text(),'Liked songs')]"


## AREA 2:
### Pre-conditions (not mutated):
- Link LikedSongs
  - Absolute: "/html/body/angular-spotify-root/as-layout/as-nav-bar/ul/li[6]/a"
  - Hook: "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-nav-bar-1]//*[@x-test-tpl-ul-3]//*[@x-test-hook-li-4][6]//*[@x-test-hook-a-5]"
  - Katalon: "(.//*[normalize-space(text()) and normalize-space(.)='My Albums'])[1]/following::a[1]"
  - Relative: "//a[normalize-space()='Liked songs']"
  - RobulaPlus:
  - Robula:
  - Selenium: "//a[contains(text(),'Liked songs')]"
- Song Card
  - Absolute: "/html/body/angular-spotify-root/as-layout/as-main-view/div[2]/as-tracks/div/div/as-playlist-track[1]/as-media-table-row/as-track-main-info"
  - Hook: "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-main-view-3]//*[@x-test-tpl-div-2]//*[@x-test-tpl-div-1]//*[@x-test-hook-as-playlist-track-11][1]//*[@x-test-tpl-as-media-table-row-1]//*[@x-test-hook-as-track-main-info-4]"
  - Katalon: "xpath=(.//*[normalize-space(text()) and normalize-space(.)='Date added'])[1]/following::as-track-main-info[1]"
  - Relative: "//as-playlist-track[1]//as-media-table-row[1]//as-track-main-info[1]"
  - RobulaPlus: 
  - Robula: 
  - Selenium: "//as-track-main-info"
### TC-PLAY-01:
- Button next
  - Absolute: "/html/body/angular-spotify-root/as-layout/as-now-playing-bar/footer/div[2]/as-player-controls/div/div[2]"
  - Hook: "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-now-playing-bar-4]//*[@x-test-tpl-footer-1]//*[@x-test-hook-as-player-controls-5]//*[@x-test-tpl-div-1]//*[@x-test-hook-div-5]"
  - Katalon: "xpath=(.//*[normalize-space(text()) and normalize-space(.)='Stop'])[1]/preceding::div[13]"
  - Relative: "//div[@class='now-playing-bar-center']//div[2]"
  - RobulaPlus:
  - Robula:
  - Selenium: "//as-player-controls/div/div[2]"
- Button previous
  - Absolute: "/html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-now-playing-bar[1]/footer[1]/div[2]/as-player-controls[1]/div[1]/div[1]"
  - Hook: "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-now-playing-bar-4]//*[@x-test-tpl-footer-1]//*[@x-test-hook-as-player-controls-5]//*[@x-test-tpl-div-1]//*[@x-test-hook-div-2]"
  - Katalon: "xpath=(.//*[normalize-space(text()) and normalize-space(.)='Stop'])[1]/preceding::div[14]"
  - Relative: "//div[@class='flex justify-center']//div[1]"
  - RobulaPlus: 
  - Robula: 
  - Selenium: "//as-player-controls/div/div"

### TC-PLAY-02:
- Button play/pause
  - Absolute: "/html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-now-playing-bar[1]/footer[1]/div[2]/as-player-controls[1]/div[1]/as-play-button[1]/button[1]"
  - Hook: "//*[@x-test-tpl-html-1]//*[@x-test-hook-angular-spotify-root-29]//*[@x-test-tpl-as-now-playing-bar-4]//*[@x-test-tpl-footer-1]//*[@x-test-hook-as-player-controls-5]//*[@x-test-tpl-div-1]//*[@x-test-hook-as-play-button-4]//*[@x-test-tpl-button-1]"
  - Katalon: "(.//*[normalize-space(text()) and normalize-space(.)='Stop'])[1]/preceding::button[2]"
  - Relative: "//button[@class='flex play-button control-button text-black bg-white']"
  - RobulaPlus:
  - Robula:
  - Selenium: "//as-player-controls/div/as-play-button/button"
- Animated icon
  - Absolute: "/html/body/angular-spotify-root/as-layout/as-now-playing-bar/footer/div[3]/as-visualization-toggle/div/svg-icon"
  - Hook: 
  - Katalon: 
  - Relative: 
  - RobulaPlus: 
  - Robula: 
  - Selenium: 
### TC-PLAY-03:
- 