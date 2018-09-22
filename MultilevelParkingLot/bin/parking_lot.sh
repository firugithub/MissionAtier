
#!/bin/bash

display_usage() { 
    echo -e "\nUsage:\n$0 [File Name is optional] \n"
}


if [[ ( $1 == "--help") ||  $1 == "-h" ]]; then
        display_usage
        exit 0
fi

fileName=$1

echo $fileName

java -jar ../target/MultilevelParkingLot-0.0.1-SNAPSHOT-shaded.jar $fileName