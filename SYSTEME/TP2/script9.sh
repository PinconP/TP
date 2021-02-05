ls -la '^-*.txt$'>fichiers_en_txt.txt
echo `wc -l fichiers_en_txt.txt`
rm fichiers_en_txt.txt
ls -la '^-*.sh$'>fichiers_en_sh.txt
echo `wc -l fichiers_en_sh.txt`
rm fichiers_en_sh.txt
ls -la