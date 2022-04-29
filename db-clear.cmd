SET POSTGRES_PATH=C:\Program Files\PostgreSQL\13\bin
"%POSTGRES_PATH%\psql.exe" -U postgres -p 5432  -c "drop database socialmusic;" -c "create database socialmusic;" -c "grant all privileges on database socialmusic to music_admin;"
