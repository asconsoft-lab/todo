FROM alpine:3.14
ARG PROFILE

ENV PROFILE ${PROFILE}
RUN echo $PROFILE hello worlds
# ARG PROFILE_ENV
# ENV PROFILE_ENV=$PROFILE
# RUN echo $PROFILE_ENV hello worlds
# RUN if [[ "$PROFILE_ENV" == "dev" ]] ; then \
#          echo $PROFILE_ENV env is set; \
#     fi
# RUN if [[ "$PROFILE_ENV" == "alpha" ]] ; then \
#          echo $PROFILE_ENV env is set. party.; \
#     fi