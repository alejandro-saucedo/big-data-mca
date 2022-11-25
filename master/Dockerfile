FROM docker.io/bde2020/spark-base:3.0.0-hadoop3.2

LABEL maintainer="Gezim Sejdiu <g.sejdiu@gmail.com>, Giannis Mouchakis <gmouchakis@gmail.com>"

COPY master.sh /

ENV SPARK_MASTER_PORT 7077
ENV SPARK_MASTER_WEBUI_PORT 8080
ENV SPARK_MASTER_LOG /spark/logs

EXPOSE 8080 7077 6066 8888

# install python 3 and jupyter notebook

ENV PYTHONUNBUFFERED=1
RUN apk add --update --no-cache gcc python3-dev python3 linux-headers musl-dev libffi-dev && \
    ln -sf python3 /usr/bin/python && \
	python3 -m ensurepip && \
	pip3 install --no-cache --upgrade pip setuptools && \
	pip3 install --no-cache notebook kafka-python

# setup python3
ENV PYSPARK_PYTHON=python3 
ENV PYSPARK_DRIVER_PYTHON=jupyter 
ENV PYSPARK_DRIVER_PYTHON_OPTS="notebook --ip=0.0.0.0 --port=8888 --no-browser --allow-root --NotebookApp.token='' --NotebookApp.password='' --NotebookApp.notebook_dir='/work/notebooks'"

CMD ["/bin/bash", "/master.sh"]
