library(spotifyr)

Sys.setenv(SPOTIFY_CLIENT_ID = '16c72804f9f34b97a90b932586dda1f4')
Sys.setenv(SPOTIFY_CLIENT_SECRET = '22b6f9cb82c04c9392b4df57e6030f89')

access_token <- get_spotify_access_token()

erykah <- get_artist_audio_features("Erykah Badu")