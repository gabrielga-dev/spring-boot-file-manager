#!/bin/bash

BUCKET_NAME=file-manager-bucket

awslocal s3api create-bucket --bucket $BUCKET_NAME

