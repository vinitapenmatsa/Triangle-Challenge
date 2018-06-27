# !/bin/bash
echo "curl http://localhost:8000/api/shape/triangle/type?sides=1&sides=1&sides=1";
curl -X GET --header 'Accept: text/plain' 'http://localhost:8000/api/shape/triangle/type?sides=1&sides=1&sides=1'
printf "\n\n*****\n\n";

echo "curl http://localhost:8000/api/shape/triangle/type?sides=2&sides=2&sides=3";
curl -X GET --header 'Accept: text/plain' 'http://localhost:8000/api/shape/triangle/type?sides=2&sides=2&sides=3'
printf "\n\n*****\n\n";

echo "curl http://localhost:8000/api/shape/triangle/type?sides=3.0&sides=4.0&sides=5.0";
curl -X GET --header 'Accept: text/plain' 'http://localhost:8000/api/shape/triangle/type?sides=3.0&sides=4.0&sides=5.0'
printf "\n\n*****\n\n";

echo "curl http://localhost:8000/api/shape/triangle/type?sides=1&sides=2&sides=3";
curl -X GET --header 'Accept: text/plain' 'http://localhost:8000/api/shape/triangle/type?sides=1&sides=2&sides=3'
printf "\n\n*****\n\n";

echo "curl http://localhost:8000/api/shape/triangle/type?sides=2&sides=2&sides=3&sides=4";
curl -X GET --header 'Accept: text/plain' 'http://localhost:8000/api/shape/triangle/type?sides=2&sides=2&sides=3&sides=4'
printf "\n\n*****\n\n";

echo "curl http://localhost:8000/api/shape/triangle/type?sides=0&sides=0&sides=0";
curl -X GET --header 'Accept: text/plain' 'http://localhost:8000/api/shape/triangle/type?sides=0&sides=0&sides=0'
printf "\n\n*****\n\n";
