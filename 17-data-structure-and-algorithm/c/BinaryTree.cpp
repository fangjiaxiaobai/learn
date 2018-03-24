//
// Created by fangxiaobai on 2018/3/21.
//

#include<stdio.h>

typedef char TYPE;

typedef struct Node{
    TYPE item;
    Node * left;
    Node * right;
} Node;


#define NODE_SIZE sizeof(Node)

/**
 * 创建一个二叉树。
 */
Node * createTree(Node * root){
    char ch ;
    ch = getchar();
    if(' '==ch ){
        root = NULL;
    }else{
        if(!(root=(Node *)malloc(NODE_SIZE))){
            printf("内存溢出");
            exit(1);
        }
        root->item = ch;
        root->left = NULL;
        root->right = NULL;
        createTree(root->left);
        createTree(root->right);
    }
}


/**
 * 先序遍历二叉树
 */
void ergodicBefore(Node * root){
    if(root==NULL){
        return ;
    }
    printf("%c" ,root->item);
    ergodicBefore(root->left);
    ergodicBefore(root->right);
}



/**
 * 中序遍历二叉树
 */
void ergodicInfix(Node * root){
    if(root==NULL){
        return ;
    }
    ergodicBefore(root->left);
    printf("%c" ,root->item);
    ergodicBefore(root->right);
}


/**
 * 后序遍历二叉树
 */
void ergodicEpilogue(Node * root){
    if(root==NULL){
        return ;
    }
    ergodicBefore(root->left);
    ergodicBefore(root->right);
    printf("%c" ,root->item);
}

/**
 * 层次遍历-使用队列
 */
typedef struct Queue
{
    TYPE item;
    Queue * next;
}Queue;


void ergodicLevel(Node *root){
    Queue queue = NULL;
    createQueue(queue,root);
}


Queue * createQueue(Queue * queueRoot,Node *root){
    if(queueRoot == root || root == NULL){
        return ;
    }
    if(queueRoot==NULL){
        queueRoot = (Queue *)malloc(sizeof(Queue));
    }
    Queue * cursor = queueRoot;
    cursor->item = root->item;
    if(root->left !=NULL){
        queue_left = (Queue *)malloc(sizeof(Queue));
        queue_left->item = root->left->item;
        printf("%s",root->item);
        sursor->next = queue_left;
        sursor = queue_left;
    }
    if(root->right!=NULL){
        queue_right = (Queue *) malloc(sizeof(Queue));
        queue_right->item = root->right->item;
        printf("%s",root->item);
        sursor->next = queue_right;
        cursor = queue_right;
    }
    createQueue(cursor->next,queueRoot->next);
}



int main(){

    createTree();


}



