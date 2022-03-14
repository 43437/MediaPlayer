cmake_minimum_required(VERSION 2.8)

set(base_dir ${CMAKE_CURRENT_LIST_DIR})

set(lib_name "SDL2")

file(GLOB src_files
    ${base_dir}/src/*.c
    ${base_dir}/src/audio/*.c
    ${base_dir}/src/audio/android/*.c
    ${base_dir}/src/audio/dummy/*.c
    ${base_dir}/src/core/android/*.c
    ${base_dir}/src/cpuinfo/*.c
    ${base_dir}/src/events/*.c
    ${base_dir}/src/file/*.c
    ${base_dir}/src/haptic/*.c
    ${base_dir}/src/haptic/dummy/*.c
    ${base_dir}/src/joystick/*.c
    ${base_dir}/src/joystick/android/*.c
    ${base_dir}/src/loadso/dlopen/*.c
    ${base_dir}/src/power/*.c
    ${base_dir}/src/power/android/*.c
    ${base_dir}/src/atomic/SDL_atomic.c
    ${base_dir}/src/atomic/SDL_spinlock.c
    ${base_dir}/src/render/*.c
    ${base_dir}/src/render/*/*.c
    ${base_dir}/src/stdlib/*.c
    ${base_dir}/src/thread/*.c
    ${base_dir}/src/thread/pthread/*.c
    ${base_dir}/src/timer/*.c
    ${base_dir}/src/timer/unix/*.c
    ${base_dir}/src/video/*.c
    ${base_dir}/src/video/android/*.c
)

set(src_lib_files
    ${src_files}
    ${base_dir}/src/atomic/SDL_atomic.c
    ${base_dir}/src/atomic/SDL_spinlock.c
)

message("source files " ${src_lib_files})

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DGL_GLEXT_PROTOTYPES")

include_directories(
            ${base_dir}/include
)

add_library(${lib_name} SHARED ${src_lib_files})

target_link_libraries(${lib_name}
                      log
                      dl
                      GLESv1_CM
                      GLESv2
)