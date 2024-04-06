FROM openjdk:17-jdk-slim


RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    xvfb \
    libxi6 \
    libgconf-2-4 \
    && rm -rf /var/lib/apt/lists/*

RUN wget -O /tmp/geckodriver.tar.gz https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-linux64.tar.gz \
    && rm -rf /opt/geckodriver \
    && tar -C /opt -zxvf /tmp/geckodriver.tar.gz \
    && rm /tmp/geckodriver.tar.gz \
    && chmod 755 /opt/geckodriver \
    && ln -fs /opt/geckodriver /usr/bin/geckodriver

ENV GECKODRIVER_PATH="/usr/bin/geckodriver"

COPY . /app
WORKDIR /app

RUN mvn clean package

CMD ["mvn", "test"]

